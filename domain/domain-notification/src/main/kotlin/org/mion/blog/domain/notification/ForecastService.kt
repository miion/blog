package org.mion.blog.domain.notification

import org.mion.blog.external.kma.api.KmaApi
import org.springframework.stereotype.Service

@Service
class ForecastService(
    private val kmaApi: KmaApi
) {

    fun find(): Map<String, Any> {
        return kmaApi.findWeatherForecast()
    }
}