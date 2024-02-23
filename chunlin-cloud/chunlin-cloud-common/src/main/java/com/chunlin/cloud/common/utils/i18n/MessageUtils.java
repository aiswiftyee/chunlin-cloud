package com.chunlin.cloud.common.utils.i18n;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 获取 i18n 资源文件
 */
public final class MessageUtils {

    /**
     * 工具类禁止实例化
     */
    private MessageUtils() {

    }

    /**
     * 根据消息键和参数获取消息，委托给 Spring {@link MessageSource}
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
