package org.mion.blog.starter.mongo.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "articles")
data class Article(
    @Id
    val id: String? = null,

    val title: String,
    val content: String,

    @CreatedBy
    val createdBy: String? = null,
    @CreatedDate
    val createdAt: LocalDateTime? = null,
    @LastModifiedBy
    val modifiedBy: String? = null,
    @LastModifiedDate
    val modifiedAt: LocalDateTime? = null,
)