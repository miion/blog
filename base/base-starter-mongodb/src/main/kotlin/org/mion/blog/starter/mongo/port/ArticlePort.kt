package org.mion.blog.starter.mongo.port

import org.mion.blog.starter.mongo.document.Article

interface ArticlePort {
    fun findArticle(id: String): Article?
    fun save(title: String, content: String): Article
}