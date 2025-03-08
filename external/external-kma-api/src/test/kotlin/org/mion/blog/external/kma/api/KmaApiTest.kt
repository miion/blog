package org.mion.blog.external.kma.api

import io.kotest.core.spec.style.FreeSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KmaApiTest @Autowired constructor(
    private val kmaApi: KmaApi

) : FreeSpec({

    "kma api test" {
        val actual = kmaApi.findWeatherForecast()
        println(actual)
    }

})
