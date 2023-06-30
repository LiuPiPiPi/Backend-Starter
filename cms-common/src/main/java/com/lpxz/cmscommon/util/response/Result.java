package com.lpxz.cmscommon.util.response;

/**
 * 请求返回结构体
 *
 * @author LPxz
 */
public class Result<T> {

    private String code;

    private String message;

    private T data;

    private long timestamp;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
