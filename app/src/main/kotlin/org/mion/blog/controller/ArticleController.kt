package org.mion.blog.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController {

    @GetMapping("/api/articles/{articleId}")
    fun article(@PathVariable articleId: Long): Long {
        return articleId;
    }

}