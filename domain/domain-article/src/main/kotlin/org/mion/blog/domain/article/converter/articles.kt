package org.mion.blog.domain.article.converter

import org.mion.blog.domain.article.dto.ArticleDto
import org.mion.blog.starter.mongo.document.Article

fun Article.toArticleDto(): ArticleDto {
    return ArticleDto(
        id = this.id.orEmpty(),
        title = this.title,
        content = this.content,
        createdAt = this.createdAt,
        createdBy = this.createdBy.orEmpty(),
        modifiedAt = this.modifiedAt,
        modifiedBy = this.modifiedBy.orEmpty(),
    )
}

fun ArticleDto.toArticle(): Article {
    return Article(
        title = this.title,
        content = this.content,
    )
}