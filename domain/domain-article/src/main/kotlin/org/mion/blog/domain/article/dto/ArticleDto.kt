package org.mion.blog.domain.article.dto

import java.time.LocalDateTime

data class ArticleDto(
    val id: String,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: LocalDateTime?,
    val modifiedBy: String,
    val modifiedAt: LocalDateTime?,
)