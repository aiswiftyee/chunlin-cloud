package com.chunlin.cloud.common.utils.poi;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.chunlin.cloud.common.exception.GlobalException;
import com.chunlin.cloud.common.exception.error.ErrorCode;
import com.chunlin.cloud.common.utils.poi.annotation.ExcelColumn;
import com.chunlin.cloud.common.utils.poi.annotation.ExcelSheet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工具类：导入/导出 Excel
 */
public final class CustomExcelUtil {

    /**
     * 工具类禁止实例化
     */
    private CustomExcelUtil() {

    }

    /**
     * 以 Excel 文件格式将给定的对象列表写入响应输出流
     *
     * @param list 要写入的对象列表
     * @param clazz 列表中对象的类
     * @param response HTTP 响应对象
     */
    public static <T> void writeToResponse(List<T> list, Class<T> clazz, HttpServletResponse response) {
        try {
            writeToOutputStream(list, clazz, response.getOutputStream());
        } catch (IOException e) {
            throw new GlobalException(e, ErrorCode.Internal.EXCEL_PROCESS_ERROR, e.getMessage());
        }
    }

    /**
     * 以 Excel 文件格式从请求输入流中读取对象，并将其作为列表返回
     *
     * @param clazz 要读取的对象的类
     * @param file 表示 Excel 文件的 MultipartFile 对象
     * @return 从输入流读取的对象列表
     */
    public static <T> List<T> readFromRequest(Class<T> clazz, MultipartFile file) {
        try {
            return readFromInputStream(clazz, file.getInputStream());
        } catch (IOException e) {
            // 注意如果是捕获到的异常，一定要放进 GlobalException 当中
            throw new GlobalException(e, ErrorCode.Internal.EXCEL_PROCESS_ERROR, e.getMessage());
        }
    }

    /**
     * 将 List 中的数据写入到 OutputStream 中
     *
     * @param list 要写入的数据
     * @param clazz 数据的类型
     * @param output 输出流
     */
    public static <T> void writeToOutputStream(List<T> list, Class<T> clazz, OutputStream output) {
        // 创建 ExcelWriter 对象
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 获取 clazz 上的 ExcelSheet 注解
        ExcelSheet sheetAnno = clazz.getAnnotation(ExcelSheet.class);

        if (sheetAnno != null) {
            // 如果存在 ExcelSheet 注解，则重命名 sheet
            writer.renameSheet(sheetAnno.name());
        }

        // 获取 clazz 上的所有字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 获取字段上的 ExcelColumn 注解
            ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
            if (annotation != null) {
                // 如果存在 ExcelColumn 注解，则添加表头别名
                writer.addHeaderAlias(field.getName(), annotation.name());
            }
        }

        // 设置只写表头别名
        writer.setOnlyAlias(true);
        // 将数据写入到 Excel 中
        writer.write(list, true);
        // 将 Excel 写入到 OutputStream 中
        writer.flush(output, true);
    }

    /**
     * 使用 Excel 阅读器从输入流中读取对象列表
     *
     * @param clazz 要读取的对象的类
     * @param inputStream 包含 Excel 数据的输入流
     * @return 从输入流中读取的对象列表
     */
    public static <T> List<T> readFromInputStream(Class<T> clazz, InputStream inputStream) {
        // 创建 Excel 阅读器并将单元格编辑器设置为 TrimXssEditor，防止 xss 注入
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        reader.setCellEditor(new TrimXssEditor());

        // 获取指定类的字段
        Field[] fields = clazz.getDeclaredFields();

        // 为使用 ExcelColumn 注解的每个字段添加标头别名
        for (Field field : fields) {
            ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
            if (annotation != null) {
                reader.addHeaderAlias(annotation.name(), field.getName());
            }
        }

        // 从输入流中读取数据并返回对象列表
        return reader.read(0, 1, clazz);
    }

}
