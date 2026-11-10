package com.myblog.service;

import com.myblog.common.PageResult;
import com.myblog.model.Article;

/**
 * Week 08 - Article 的全生命周期：publish / read / discover / revise / withdraw。
 */
public interface ArticleService {

    Article publish(Article article);

    Article get(Long id);

    PageResult<Article> discover(String keyword, Integer page, Integer size);

    Article revise(Long id, Article changes);

    void withdraw(Long id);
}
