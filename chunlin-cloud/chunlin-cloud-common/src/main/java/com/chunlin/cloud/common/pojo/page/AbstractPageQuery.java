package com.chunlin.cloud.common.pojo.page;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.validation.constraints.Max;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询构造器
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractPageQuery<T> extends AbstractQuery<T> {

    /**
     * 最大分页页数
     */
    public static final int MAX_PAGE_NUM = 200;

    /**
     * 单页最大大小
     */
    public static final int MAX_PAGE_SIZE = 500;

    /**
     * 默认分页页数
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    @Max(MAX_PAGE_NUM)
    protected Integer pageNum;

    @Max(MAX_PAGE_SIZE)
    protected Integer pageSize;

    /**
     * 将当前对象转换为分页对象
     *
     * @return 分页对象
     */
    public Page<T> toPage() {
        pageNum = ObjectUtil.defaultIfNull(pageNum, DEFAULT_PAGE_NUM);
        pageSize = ObjectUtil.defaultIfNull(pageSize, DEFAULT_PAGE_SIZE);
        return new Page<>(pageNum, pageSize);
    }

}
