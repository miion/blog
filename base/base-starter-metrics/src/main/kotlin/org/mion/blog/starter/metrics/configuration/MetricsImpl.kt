package org.mion.blog.starter.metrics.configuration

import io.micrometer.core.instrument.DistributionSummary
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.Timer
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry
import org.mion.blog.common.metrics.Metrics
import org.mion.blog.common.metrics.Metrics.Companion.PERCENTILES
import org.mion.blog.common.metrics.Metrics.Companion.SLO
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class MetricsImpl(
    private val meterRegistry: PrometheusMeterRegistry,
) : Metrics {


    override fun count(name: String, value: Long, tags: List<Tag>) {
        meterRegistry.counter(name, tags).increment(value.toDouble())
    }

    override fun count(name: String, tags: List<Tag>) {
        meterRegistry.counter(name, tags).increment()
    }

    override fun gauge(name: String, value: Long, tags: List<Tag>) {
        Gauge.builder(name, value, Number::toDouble)
            .strongReference(true)
            .tags(tags)
            .register(meterRegistry)
    }

    override fun timer(name: String, value: Long, tags: List<Tag>) {
        Timer.builder(name)
            .serviceLevelObjectives(*SLO)
            .tags(tags)
            .register(meterRegistry)
            .record(value, TimeUnit.MILLISECONDS)
    }

    override fun summary(name: String, value: Double, tags: List<Tag>) {
        DistributionSummary.builder(name)
            .publishPercentiles(*PERCENTILES)
            .tags(tags)
            .register(meterRegistry)
            .record(value)
    }
}