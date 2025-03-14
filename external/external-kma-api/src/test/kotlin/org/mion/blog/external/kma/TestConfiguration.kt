package org.mion.blog.external.kma

import org.mion.blog.starter.base.http.configuration.HttpInterfaceFactoryBeanFactoryPostProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(HttpInterfaceFactoryBeanFactoryPostProcessor::class)
class TestConfiguration