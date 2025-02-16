package org.mion.blog.starter.metrics.configuration

import io.micrometer.prometheusmetrics.PrometheusConfig
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MetricsConfiguration {

    @Bean
    fun prometheusRegistry(): PrometheusMeterRegistry {
        val registry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
        return registry;
    }

}