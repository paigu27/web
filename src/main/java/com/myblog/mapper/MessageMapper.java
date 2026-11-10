package com.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.model.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * Week 06 - 通往记忆宫殿的桥：整个文件就五行。
 * MyBatis Plus 从 entity + 表名自动补全常见 insert / select / delete。
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
