package com.chunlin.cloud.common.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chunlin.cloud.common.exception.GlobalException;
import com.chunlin.cloud.common.exception.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应信息主体
 */
@Data
@AllArgsConstructor
public class ResponseResult<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 响应数据
     */
    @JsonInclude
    private T data;

    /**
     * 构建成功响应结果
     *
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> success() {
        return build(null, ErrorCode.SUCCESS.code(), ErrorCode.SUCCESS.message());
    }

    /**
     * 构建成功响应结果
     *
     * @param data 响应数据
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> success(T data) {
        return build(data, ErrorCode.SUCCESS.code(), ErrorCode.SUCCESS.message());
    }

    /**
     * 构建失败响应结果
     *
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> fail() {
        return build(null, ErrorCode.FAILED.code(), ErrorCode.FAILED.message());
    }

    /**
     * 构建失败响应结果
     *
     * @param data 数据
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> fail(T data) {
        return build(data, ErrorCode.FAILED.code(), ErrorCode.FAILED.message());
    }

    /**
     * 构建失败响应结果
     *
     * @param exception 异常对象
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> fail(GlobalException exception) {
        return build(null, exception.getErrorCode().code(), exception.getMessage());
    }

    /**
     * 构建失败响应结果
     *
     * @param exception 异常对象
     * @param data 数据
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> fail(GlobalException exception, T data) {
        return build(data, exception.getErrorCode().code(), exception.getMessage());
    }

    /**
     * 构建响应结果
     *
     * @param data 数据
     * @param code 错误码
     * @param msg 错误信息
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult<T> build(T data, Integer code, String msg) {
        return new ResponseResult<>(code, msg, data);
    }

}
