package org.mion.blog.domain.notification.service

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.mion.blog.domain.notification.ForecastService
import org.mion.blog.external.kma.api.KmaApi

class ForecastServiceTest : FreeSpec({

    val kmaApi = mockk<KmaApi>()
    val sut = ForecastService(kmaApi)

    "kma api test" {
        val expected = mapOf<String, Any>()
        every { kmaApi.findWeatherForecast() } returns expected

        val actual = sut.find()

        actual shouldBe expected
    }

})