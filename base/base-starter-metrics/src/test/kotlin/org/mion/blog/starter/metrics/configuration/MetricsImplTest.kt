package org.mion.blog.starter.metrics.configuration

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.micrometer.core.instrument.Tag
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MetricsImplTest(
    metricsImpl: MetricsImpl,
    meterRegistry: PrometheusMeterRegistry,
) : FreeSpec({

    "counter" {
        val name = "name"
        val tags = listOf(Tag.of("key", "value"))
        metricsImpl.count(name, tags)
        metricsImpl.count(name, tags)

        meterRegistry.get(name).tags("key", "value").counter().count() shouldBe 2

        metricsImpl.count(name, 2, tags)
        meterRegistry.get(name).tags("key", "value").counter().count() shouldBe 4
    }

})

