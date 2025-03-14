package org.mion.blog.external.kma.api

import org.mion.blog.external.kma.adapter.KmaAdapter
import org.mion.blog.external.kma.adapter.KmaHttpInterface
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class KmaApi(
    private val kmaAdapter: KmaAdapter,
    private val kmaHttpInterface: KmaHttpInterface,
    @Value("\${kma.authkey}") private val authKey: String
) {

    fun findWeatherForecast(): Map<String, Any> {
        return kmaAdapter.getVilageFcst(
            baseDate = "20250308",
            baseTime = "2300",
            nx = 55,
            ny = 127,
            authKey = authKey
        )
    }

    fun findWeatherForecast2(): Map<String, Any> {
        return kmaHttpInterface.getVilageFcst(
            baseDate = "20250308",
            baseTime = "2300",
            nx = 55,
            ny = 127,
            authKey = authKey
        )
    }

}