package com.lpxz.cmscommon.util.response;

/**
 * @author LPxz
 * @date 2023/6/30
 */
public class ResultHelper {

    /**
     * 只返回状态
     *
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS.getCode())
                .setMessage(ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 只返回信息
     *
     * @param message
     * @return
     */
    public static <T> Result<T> success(String message) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS.getCode())
                .setMessage(message);
    }

    /**
     * 只返回数据
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS.getCode())
                .setMessage(ResultCodeEnum.SUCCESS.getMessage())
                .setData(data);
    }

    /**
     * 成功返回数据
     *
     * @param data
     * @param message
     * @return
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS.getCode())
                .setMessage(message)
                .setData(data);
    }

    /**
     * 失败 只返回状态
     *
     * @return
     */
    public static <T> Result<T> error() {
        return new Result<T>()
                .setCode(ResultCodeEnum.ERROR.getCode())
                .setMessage(ResultCodeEnum.ERROR.getMessage());
    }

    /**
     * 失败 只返回信息
     *
     * @param message
     * @return
     */
    public static <T> Result<T> error(String message) {
        return new Result<T>()
                .setCode(ResultCodeEnum.ERROR.getCode())
                .setMessage(message);
    }

    /**
     * 失败 设置状态码
     *
     * @param code
     * @param message
     * @return
     */
    public static <T> Result<T> error(String code, String message) {
        return new Result<T>()
                .setCode(code)
                .setMessage(message);
    }
}
