package org.mion.blog.controller

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.mion.blog.domain.article.service.ArticleService
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockKExtension::class)
@WebMvcTest(ArticleController::class)
class ArticleControllerTest : StringSpec({

    val articleService = mockk<ArticleService>()

    val articleController = ArticleController(articleService)
    val mockMvc = MockMvcBuilders.standaloneSetup(articleController).build()

    "get articles" {
        every { articleService.findArticle(any()) } returns null

        mockMvc.perform(get("/api/articles/1"))
            .andExpect(status().isOk())
    }
})