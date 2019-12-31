package com.hy.learn.springboot.demo.common;

/**
 * 枚举了一些常用API操作码
 *
 * @author hy
 * @date 2019/12/24
 */
public enum ResultCode implements IErrorCode {

    /**
     * 10000 正常，操作成功
     * 20000-29999 逻辑异常及操作异常，包括余额不足，修改信息失败
     * 40000-49999 参数异常及权限异常，包括账户密码错误，接口参数错误，接口参数超出范围
     * 50000-59999 接口异常及服务异常，50000服务器内部错误，50001服务器维护中。50002服务器繁忙等
     */

    /**
     * 操作成功
     */
    SUCCESS(10000, "操作成功"),
    FAILED(20000, "操作失败"),
    VALIDATE_FAILED(40000, "参数检验失败"),
    UNAUTHORIZED(40001, "暂未登录或token已经过期"),
    FORBIDDEN(40002, "没有相关权限"),
    SERVER_ERROR(50000,"内部错误");

    private Integer code;

    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
