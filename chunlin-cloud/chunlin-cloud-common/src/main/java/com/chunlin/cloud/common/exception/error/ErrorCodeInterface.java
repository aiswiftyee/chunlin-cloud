package com.chunlin.cloud.common.exception.error;

/**
 * 错误码
 */
public interface ErrorCodeInterface {

    /**
     * 返回错误码
     *
     * @return 错误码
     */
    int code();

    /**
     * 返回具体的详细错误描述
     *
     * @return 错误描述
     */
    String message();

    /**
     * i18n 资源文件的 key, 详见 messages.properties 文件
     *
     * @return key
     */
    String i18nKey();

}
