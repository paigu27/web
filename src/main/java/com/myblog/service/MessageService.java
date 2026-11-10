package com.myblog.service;

import com.myblog.common.PageResult;
import com.myblog.model.Message;
import com.myblog.model.MessageRequest;

/**
 * Week 05 - 决策室：业务规则住在这里（validation / identity / voice）。
 * Service 内部不出现 HTTP 路径、@RequestBody、SQL。
 */
public interface MessageService {

    /** 校验内容、交给存储、返回带 id 的留言。 */
    Message create(MessageRequest request);

    /** Week 07：keyword 过滤 + 分页浏览记忆。 */
    PageResult<Message> list(String keyword, Integer page, Integer size);

    /** 按 id 取一条留言；不存在时抛 NoSuchElementException。 */
    Message get(Long id);
}
