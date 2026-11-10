package com.myblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * Week 06 - 一条被记住的留言（Entity：记忆的 Java 名字）。
 * Entity <-> Table 映射：id<->id, content<->content, createdAt<->created_at
 */
@TableName("message")
public class Message {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
