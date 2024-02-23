package com.chunlin.cloud.common.pojo.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import lombok.Data;

/**
 * 分页模型类
 */
@Data
public class PageDTO<T> {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 列表数据
     */
    private List<T> rows;

    /**
     * 构造函数
     *
     * @param list 数据列表
     */
    public PageDTO(List<T> list) {
        this.rows = list;
        this.total = (long) list.size();
    }

    /**
     * 构造函数
     *
     * @param page 分页对象
     */
    public PageDTO(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }

    /**
     * 构造函数
     *
     * @param list 数据列表
     * @param count 总数
     */
    public PageDTO(List<T> list, Long count) {
        this.rows = list;
        this.total = count;
    }

}

