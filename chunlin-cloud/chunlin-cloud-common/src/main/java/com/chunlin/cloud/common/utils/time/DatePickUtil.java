package com.chunlin.cloud.common.utils.time;

import cn.hutool.core.date.DateUtil;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DatePickUtil {

    /**
     * 工具类禁止实例化
     */
    private DatePickUtil() {

    }

    /**
     * 获取指定日期的当天开始时间
     *
     * @param date 指定日期
     * @return 当天开始时间
     */
    public static Date getBeginOfTheDay(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return DateUtil.beginOfDay(date);
        } catch (Exception e) {
            log.error("pick begin of the day failed, due to: ", e);
        }
        return null;
    }

    /**
     * 获取指定日期的当天结束时间
     *
     * @param date 指定日期
     * @return 当天结束时间
     */
    public static Date getEndOfTheDay(Date date) {
        if (date == null) {
            return null;
        }

        try {
            return DateUtil.endOfDay(date);
        } catch (Exception e) {
            log.error("pick end of the day failed, due to: ", e);
        }
        return null;
    }

}
