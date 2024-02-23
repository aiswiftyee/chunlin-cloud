package com.chunlin.cloud.common.exception;

import cn.hutool.core.util.StrUtil;
import com.chunlin.cloud.common.exception.error.ErrorCodeInterface;
import com.chunlin.cloud.common.utils.i18n.MessageUtils;
import java.util.HashMap;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class GlobalException extends RuntimeException {

    /**
     * 原始异常消息
     */
    protected String message;

    /**
     * 国际化异常消息
     */
    protected String i18nMessage;

    /**
     * 异常代码
     */
    protected ErrorCodeInterface errorCode;

    /**
     * 特殊的错误处理
     * <ul>
     *     <li>有时候错误的返回信息太少，不便前端处理的情况，可以放在这个字段当中</li>
     *     <li>比如，大批量操作，操作 ID 为 1~10 的实体，其中 1~5 成功，6~10 失败，则可以将这些相关信息放在这个字段中</li>
     * </ul>
     */
    protected HashMap<String, Object> payload;

    public GlobalException(ErrorCodeInterface errorCode) {
        fillErrorCode(errorCode);
    }

    public GlobalException(ErrorCodeInterface errorCode, Object... args) {
        fillErrorCode(errorCode, args);
    }

    /**
     * 注意，如果是 try catch 的情况下捕获异常并转为 GlobalException 的话，一定要填入 Throwable e
     *
     * @param e 捕获到的原始异常
     * @param errorCode 错误码
     * @param args 错误详细信息参数
     */
    public GlobalException(Throwable e, ErrorCodeInterface errorCode, Object... args) {
        super(e);
        fillErrorCode(errorCode, args);
    }

    private void fillErrorCode(ErrorCodeInterface errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = StrUtil.format(errorCode.message(), args);

        try {
            this.i18nMessage = MessageUtils.message(errorCode.i18nKey(), args);
        } catch (Exception e) {
            log.error("could not found i18nMessage entry for key: " + errorCode.i18nKey());
        }
    }

    @Override
    public String getMessage() {
        return i18nMessage != null ? i18nMessage : message;
    }

    @Override
    public String getLocalizedMessage() {
        return i18nMessage != null ? i18nMessage : message;
    }

}
