package com.myblog.controller;

import com.myblog.common.PageResult;
import com.myblog.model.Message;
import com.myblog.model.MessageRequest;
import com.myblog.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Week 04 - POST /messages：MyBlog 学会倾听（I Can Listen）。
 * Week 05 - 重构后 Controller 保持薄：收请求 -> 调 Service -> 还响应。
 * Week 07 - GET /messages 支持 keyword + page + size。
 */
@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public Message create(@RequestBody MessageRequest request) {
        return messageService.create(request);
    }

    @GetMapping("/messages")
    public PageResult<Message> all(@RequestParam(required = false) String keyword,
                                   @RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Integer size) {
        return messageService.list(keyword, page, size);
    }

    @GetMapping("/messages/{id}")
    public Message one(@PathVariable Long id) {
        return messageService.get(id);
    }
}
