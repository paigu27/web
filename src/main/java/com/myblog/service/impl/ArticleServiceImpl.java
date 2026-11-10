package com.myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.common.PageResult;
import com.myblog.mapper.ArticleMapper;
import com.myblog.model.Article;
import com.myblog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

/**
 * Week 08 - Article 的决策逻辑。复用 Week 07 的 like + selectPage 思维，只是字段变了。
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper mapper;

    public ArticleServiceImpl(ArticleMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Article publish(Article article) {
        if (article == null || article.getTitle() == null || article.getTitle().isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (article.getContent() == null || article.getContent().isBlank()) {
            throw new IllegalArgumentException("content is required");
        }
        article.setId(null);
        article.setCreatedAt(LocalDateTime.now());
        mapper.insert(article);
        return article;
    }

    @Override
    public Article get(Long id) {
        Article article = mapper.selectById(id);
        if (article == null) {
            throw new NoSuchElementException("article " + id + " not found");
        }
        return article;
    }

    @Override
    public PageResult<Article> discover(String keyword, Integer page, Integer size) {
        int p = (page == null || page < 1) ? 1 : page;
        int s = (size == null || size < 1) ? 10 : size;
        QueryWrapper<Article> qw = new QueryWrapper<>();
        if (keyword != null && !keyword.isBlank()) {
            // 统一大小写：LIKE 在不同数据库上的大小写行为不同，lower 后比较可移植
            String kw = keyword.toLowerCase();
            qw.apply("LOWER(title) LIKE {0}", "%" + kw + "%")
              .or()
              .apply("LOWER(content) LIKE {0}", "%" + kw + "%");
        }
        qw.orderByDesc("created_at").orderByAsc("id");
        Page<Article> result = mapper.selectPage(new Page<>(p, s), qw);
        return new PageResult<>(result.getRecords(), result.getTotal(), p, s);
    }

    @Override
    public Article revise(Long id, Article changes) {
        Article article = get(id);
        if (changes.getTitle() != null && !changes.getTitle().isBlank()) {
            article.setTitle(changes.getTitle());
        }
        if (changes.getContent() != null && !changes.getContent().isBlank()) {
            article.setContent(changes.getContent());
        }
        mapper.updateById(article);
        return article;
    }

    @Override
    public void withdraw(Long id) {
        get(id);
        mapper.deleteById(id);
    }
}
