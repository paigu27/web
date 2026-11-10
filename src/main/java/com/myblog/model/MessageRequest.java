package com.myblog.model;

/**
 * Week 04 - 入站 DTO：访客发来的 JSON 绑定到这个类。
 * @RequestBody 让 Jackson 反向运行（JSON -> Java）。
 */
public class MessageRequest {
    public String content;
}
