package org.mion.blog.starter.mongo.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAwareImpl")
class MongoConfiguration {

    @Bean
    fun auditorAwareImpl(): AuditorAwareImpl {
        return AuditorAwareImpl()
    }

}