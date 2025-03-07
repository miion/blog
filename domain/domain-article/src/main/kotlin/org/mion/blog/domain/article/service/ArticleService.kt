package org.mion.blog.domain.article.service

import org.mion.blog.domain.article.converter.toArticleDto
import org.mion.blog.domain.article.dto.ArticleDto
import org.mion.blog.starter.mongo.port.ArticlePort
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articlePort: ArticlePort
) {

    fun findArticle(id: String): ArticleDto? {
        return articlePort.findArticle(id)?.toArticleDto()
    }

    fun saveArticle(title: String, content: String): ArticleDto {
        return articlePort.save(title, content).toArticleDto()
    }

}