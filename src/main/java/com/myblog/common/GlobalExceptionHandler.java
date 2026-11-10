package com.myblog.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * Week 08 - 全局异常处理：把 not-found 等错误也纳入 JSON 契约，
 * 不再吐 HTML 错误页。设计良好的错误响应比完美的成功响应更能体现完整性。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public Result<Void> notFound(NoSuchElementException e) {
        return Result.fail(HttpStatus.NOT_FOUND.value(), "not found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Void> badRequest(IllegalArgumentException e) {
        return Result.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
