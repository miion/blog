package org.mion.blog.starter.base.http.configuration

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.env.Environment
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.web.service.annotation.HttpExchange

class HttpInterfaceClassFinder {

    fun findBeanDefinitions(environment: Environment): Set<BeanDefinition> {
        val scanner = object : ClassPathScanningCandidateComponentProvider(false, environment) {
            override fun isCandidateComponent(beanDefinition: AnnotatedBeanDefinition): Boolean {
                return beanDefinition.metadata.isInterface
                        && beanDefinition.metadata.hasAnnotation(HttpExchange::class.qualifiedName!!)
            }
        }
        scanner.addIncludeFilter(AnnotationTypeFilter(HttpExchange::class.java))
        return scanner.findCandidateComponents("org.mion.blog.external")
    }
}