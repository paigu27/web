package com.myblog.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.common.PageResult;
import com.myblog.mapper.MessageMapper;
import com.myblog.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Week 06 - MySQL 实现：记忆宫殿的真正住户。
 * 只换边界之下的存储实现，不碰边界之上的任何东西。
 * Week 07 - search 用 like + selectPage 让 MySQL 在源头做它擅长的事。
 */
@Repository
public class MysqlMessageRepository implements MessageRepository {

    private final MessageMapper mapper;

    public MysqlMessageRepository(MessageMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Message save(Message message) {
        if (message.getCreatedAt() == null) {
            message.setCreatedAt(java.time.LocalDateTime.now());
        }
        mapper.insert(message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return mapper.selectList(new QueryWrapper<Message>().orderByAsc("id"));
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(mapper.selectById(id));
    }

    @Override
    public PageResult<Message> search(String keyword, int page, int size) {
        QueryWrapper<Message> qw = new QueryWrapper<>();
        if (keyword != null && !keyword.isBlank()) {
            // 统一大小写：LIKE 在不同数据库上的大小写行为不同，lower 后比较可移植
            qw.apply("LOWER(content) LIKE {0}", "%" + keyword.toLowerCase() + "%");
        }
        qw.orderByDesc("created_at").orderByAsc("id");
        Page<Message> result = mapper.selectPage(new Page<>(page, size), qw);
        return new PageResult<>(result.getRecords(), result.getTotal(), page, size);
    }
}
