package org.mion.blog.starter.metrics.controller

import io.micrometer.core.instrument.Tag
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry
import org.mion.blog.common.metrics.Metrics
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MetricsController(
    private val prometheusMeterRegistry: PrometheusMeterRegistry,
    private val metrics: Metrics,
) {


    @GetMapping("/metrics", produces = ["text/plain"])
    fun metrics(): String {
        return prometheusMeterRegistry.scrape()
    }

    @GetMapping("/add")
    fun add(): Boolean {
        metrics.count("hello", listOf(Tag.of("tag1", "1")))
        return true
    }
}