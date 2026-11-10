package com.myblog.controller;

import com.myblog.common.PageResult;
import com.myblog.common.Result;
import com.myblog.model.Article;
import com.myblog.service.ArticleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Week 08 - 五个端点，一种契约：
 *   POST   /articles          发布（publish）
 *   GET    /articles/{id}     读取单篇（read one）
 *   GET    /articles          发现/浏览（discover，keyword+page+size）
 *   PUT    /articles/{id}     修订（revise）——八周以来第一个更新动词
 *   DELETE /articles/{id}     撤回（withdraw）
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Result<Article> publish(@RequestBody Article article) {
        return Result.ok(articleService.publish(article));
    }

    @GetMapping("/{id}")
    public Result<Article> one(@PathVariable Long id) {
        return Result.ok(articleService.get(id));
    }

    @GetMapping
    public Result<PageResult<Article>> discover(@RequestParam(required = false) String keyword,
                                                @RequestParam(required = false) Integer page,
                                                @RequestParam(required = false) Integer size) {
        return Result.ok(articleService.discover(keyword, page, size));
    }

    @PutMapping("/{id}")
    public Result<Article> revise(@PathVariable Long id, @RequestBody Article changes) {
        return Result.ok(articleService.revise(id, changes));
    }

    @DeleteMapping("/{id}")
    public Result<Void> withdraw(@PathVariable Long id) {
        articleService.withdraw(id);
        return Result.ok(null);
    }
}
