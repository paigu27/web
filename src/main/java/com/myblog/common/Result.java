package com.myblog.common;

/**
 * Week 08 - 统一响应契约：无论发生什么，响应体都是同一骨架 {code, message, data}。
 * code 让前端判断成败；message 是人类可读的信息；data 是载荷（即使 null 也在）。
 */
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result() {}

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "ok", data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
