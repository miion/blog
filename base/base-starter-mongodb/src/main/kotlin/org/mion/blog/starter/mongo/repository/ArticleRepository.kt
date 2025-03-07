package org.mion.blog.starter.mongo.repository

import org.mion.blog.starter.mongo.document.Article
import org.springframework.data.mongodb.repository.MongoRepository

interface ArticleRepository: MongoRepository<Article, String> {
}