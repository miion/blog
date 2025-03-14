package org.mion.blog.external.kma.api

import io.kotest.core.spec.style.FreeSpec
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.openfeign.FeignAutoConfiguration

@SpringBootTest(
    properties = ["kma.authkey=VO1yBfc1RdatcgX3NTXWdA"]
)
@ImportAutoConfiguration(FeignAutoConfiguration::class)
class KmaApiTest(
    private val kmaApi: KmaApi
) : FreeSpec({

    "kma api test" {
        val actual = kmaApi.findWeatherForecast()
        println(actual)
    }

    "kma api test2" {
        val actual = kmaApi.findWeatherForecast2()
        println(actual)
    }


})
