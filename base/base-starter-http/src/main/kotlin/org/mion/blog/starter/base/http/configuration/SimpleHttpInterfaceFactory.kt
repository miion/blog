package org.mion.blog.starter.base.http.configuration

import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.invoker.HttpServiceProxyFactory

class SimpleHttpInterfaceFactory {
    fun <S> create(clientClass: Class<S>): S {
        val httpExchange: HttpExchange = clientClass.getAnnotation(HttpExchange::class.java)
            ?: throw IllegalStateException("HttpExchange annotation not found")

        if (httpExchange.value.isEmpty()) {
            throw IllegalArgumentException("HttpExchange url is empty")
        }

        val restClient = RestClient.create()
        val restClientAdapter = RestClientAdapter.create(restClient)

        return HttpServiceProxyFactory
            .builderFor(restClientAdapter)
            .build()
            .createClient(clientClass)
    }
}