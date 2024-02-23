package com.chunlin.cloud.common.pojo.base;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Controller 基类
 */
public abstract class BaseController {

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为 Date 类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtil.parseDate(text));
            }
        });
    }

    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StrUtil.format("redirect:{}", url);
    }

}

