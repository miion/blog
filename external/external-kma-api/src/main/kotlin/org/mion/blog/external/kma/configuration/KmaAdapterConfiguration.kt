package org.mion.blog.external.kma.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(
    basePackages = ["org.mion.blog.external.kma"]
)
@Configuration
class KmaAdapterConfiguration