package com.chunlin.cloud.common.utils.poi;

import cn.hutool.http.HtmlUtil;
import cn.hutool.poi.excel.cell.CellEditor;
import org.apache.poi.ss.usermodel.Cell;

/**
 * 读取 Excel 的时候，去除掉 HTML 相关的标签，避免 xss 注入
 */
public class TrimXssEditor implements CellEditor {

    /**
     * 编辑指定单元格中的值
     *
     * @param cell 要编辑的单元格
     * @param value 要编辑的值
     * @return 编辑后的值
     */
    @Override
    public Object edit(Cell cell, Object value) {
        // 检查值是否为字符串
        if (value instanceof String) {
            // 从字符串值中截取 XSS 标记
            return HtmlUtil.cleanHtmlTag(value.toString());
        }
        // 如果值不是字符串，则按原样返回值
        return value;
    }
}

