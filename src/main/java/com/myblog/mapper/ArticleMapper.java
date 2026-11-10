package com.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.model.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * Week 08 - Article 的 Mapper。
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
