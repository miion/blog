package org.mion.blog.starter.mongo.adapter

import org.mion.blog.starter.mongo.document.Article
import org.mion.blog.starter.mongo.port.ArticlePort
import org.mion.blog.starter.mongo.repository.ArticleRepository
import org.springframework.stereotype.Component

@Component
class ArticleAdapter(
    private val articleRepository: ArticleRepository
) : ArticlePort {
    override fun findArticle(id: String): Article? {
        return articleRepository.findById(id).orElse(null)
    }

    override fun save(title: String, content: String): Article {
        val article = Article(
            title = title,
            content = content
        )
        return articleRepository.save(article)
    }
}