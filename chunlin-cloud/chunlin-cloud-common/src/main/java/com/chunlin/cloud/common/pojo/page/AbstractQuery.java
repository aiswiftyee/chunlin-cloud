package com.chunlin.cloud.common.pojo.page;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.chunlin.cloud.common.utils.time.DatePickUtil;
import java.util.Date;
import lombok.Data;

/**
 * 如果是简单的排序或时间范围筛选，可以使用内置的这几个字段
 */
@Data
public abstract class AbstractQuery<T> {

    /**
     * 数据的顺序
     */
    private static final String ASC = "ascending";
    private static final String DESC = "descending";

    /**
     * 要作为数据排序依据的列
     */
    protected String orderColumn;

    /**
     * 排序的方向
     */
    protected String orderDirection;

    /**
     * 用于按时间范围筛选数据的列
     */
    protected String timeRangeColumn;

    /**
     * 时间范围的开始时间
     */
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private Date beginTime;

    /**
     * 时间范围的结束时间
     */
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 构造查询条件
     *
     * @return 查询构造器
     */
    public QueryWrapper<T> toQueryWrapper() {
        QueryWrapper<T> queryWrapper = addQueryCondition(); // 添加查询条件
        addSortCondition(queryWrapper); // 添加排序条件
        addTimeCondition(queryWrapper); // 添加时间条件

        return queryWrapper;
    }

    /**
     * 添加查询条件
     *
     * @return 查询构造器
     */
    public abstract QueryWrapper<T> addQueryCondition();

    /**
     * 添加排序条件
     *
     * @param queryWrapper 查询构造器
     */
    public void addSortCondition(QueryWrapper<T> queryWrapper) {
        if (queryWrapper == null || StrUtil.isEmpty(orderColumn)) {
            return;
        }

        Boolean sortDirection = convertSortDirection();
        if (sortDirection != null) {
            queryWrapper.orderBy(StrUtil.isNotEmpty(orderColumn), sortDirection, StrUtil.toUnderlineCase(orderColumn));
        }
    }

    /**
     * 添加时间范围条件
     *
     * @param queryWrapper 查询构造器
     */
    public void addTimeCondition(QueryWrapper<T> queryWrapper) {
        if (queryWrapper != null && StrUtil.isNotEmpty(this.timeRangeColumn)) {
            queryWrapper.ge(beginTime != null, StrUtil.toUnderlineCase(timeRangeColumn),
                    DatePickUtil.getBeginOfTheDay(beginTime)).le(endTime != null,
                    StrUtil.toUnderlineCase(timeRangeColumn), DatePickUtil.getEndOfTheDay(endTime));
        }
    }

    /**
     * 转换排序方向
     *
     * @return 排序方向：true-正序，false-倒序
     */
    public Boolean convertSortDirection() {
        Boolean isAsc = null;
        if (StrUtil.isEmpty(this.orderDirection)) {
            return isAsc;
        }

        if (ASC.equals(this.orderDirection)) {
            isAsc = true;
        }
        if (DESC.equals(this.orderDirection)) {
            isAsc = false;
        }

        return isAsc;
    }

}

