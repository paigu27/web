package com.myblog.service.impl;

import com.myblog.common.PageResult;
import com.myblog.model.Message;
import com.myblog.model.MessageRequest;
import com.myblog.repository.MessageRepository;
import com.myblog.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Week 05 - 决策逻辑的唯一住所：
 *   - 消息是否为空？（validation）
 *   - id 从哪里来？（identity：交给存储层自增）
 *   - 措辞是我们的还是访客的？（voice：原样保存访客的话）
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    /** Week 05 - 构造器注入：依赖在出生时递进来，不手写 new。 */
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message create(MessageRequest request) {
        if (request == null || request.content == null || request.content.isBlank()) {
            throw new IllegalArgumentException("content is required");
        }
        Message message = new Message();
        message.setContent(request.content);
        return repository.save(message);
    }

    @Override
    public PageResult<Message> list(String keyword, Integer page, Integer size) {
        int p = (page == null || page < 1) ? 1 : page;
        int s = (size == null || size < 1) ? 10 : size;
        String kw = (keyword == null || keyword.isBlank()) ? null : keyword;
        return repository.search(kw, p, s);
    }

    @Override
    public Message get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("message " + id + " not found"));
    }
}
