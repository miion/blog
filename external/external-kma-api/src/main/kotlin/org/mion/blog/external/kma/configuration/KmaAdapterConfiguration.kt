package org.mion.blog.external.kma.configuration

import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients(
    basePackages = ["org.mion.blog.external.kma"]
)
class KmaAdapterConfiguration