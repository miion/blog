package org.mion.blog.common.metrics

import io.micrometer.core.instrument.Tag
import java.time.Duration

interface Metrics {

    companion object {
        val SLO = arrayOf(10L, 100L, 500L, 1_000L, 2_000L, 3_000L).map { Duration.ofMillis(it) }.toTypedArray()
        val PERCENTILES: DoubleArray = doubleArrayOf(0.5, 0.75, 0.95, 0.99)
    }

    fun count(name: String, value: Long, tags: List<Tag>)
    fun count(name: String, tags: List<Tag>)
    fun gauge(name: String, value: Long, tags: List<Tag>)
    fun timer(name: String, value: Long, tags: List<Tag>)
    fun summary(name: String, value: Double, tags: List<Tag>)

}