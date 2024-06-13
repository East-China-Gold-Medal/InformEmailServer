package com.EastChinaGoldMedal.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private T data;

    // 成功响应静态工厂方法

    /**
     * 创建默认的成功响应，不带数据
     *
     * @return 成功的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<>(200, "操作成功", null);
    }

    /**
     * 创建成功的响应
     *
     * @param data 响应数据
     * @return 成功的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(200, "操作成功", data);
    }

    /**
     * 创建带有自定义消息的成功响应
     *
     * @param message 自定义成功消息
     * @param data 响应数据
     * @return 成功的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> success(String message, T data) {
        return new ResponseDTO<>(200, message, data);
    }

    // 常见错误码静态工厂方法

    /**
     * 创建没有具体消息的错误响应，默认错误码为500
     *
     * @return 错误的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> error() {
        return error(500, "服务器内部错误");
    }

    /**
     * 创建错误响应
     *
     * @param code 错误状态码
     * @param message 错误消息
     * @return 错误的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> error(Integer code, String message) {
        return new ResponseDTO<>(code, message, null);
    }

    // 预设一些常见错误码的静态工厂方法

    /**
     * 创建请求参数错误的响应
     *
     * @return 错误的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> badRequest() {
        return error(400, "请求参数错误");
    }

    /**
     * 创建未授权错误的响应
     *
     * @return 错误的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> unauthorized() {
        return error(401, "未授权");
    }

    /**
     * 创建资源未找到错误的响应
     *
     * @return 错误的ResponseDTO实例
     */
    public static <T> ResponseDTO<T> notFound() {
        return error(404, "资源未找到");
    }
}
