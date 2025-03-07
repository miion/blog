package org.mion.blog.controller

import org.mion.blog.domain.article.dto.ArticleDto
import org.mion.blog.domain.article.service.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
class ArticleController(
    private val articleService: ArticleService
) {

    @GetMapping("/api/articles/{articleId}")
    fun article(@PathVariable articleId: String): ArticleDto? {
        return articleService.findArticle(articleId)
    }

    @PostMapping("/api/articles")
    fun article(@RequestBody body: Map<String, String>): ArticleDto {
        val title = body["title"].toString()
        val content = body["content"].toString()
        return articleService.saveArticle(title, content)
    }

}