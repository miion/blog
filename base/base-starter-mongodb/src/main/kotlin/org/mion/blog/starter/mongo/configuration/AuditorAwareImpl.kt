package org.mion.blog.starter.mongo.configuration

import org.springframework.data.domain.AuditorAware
import java.util.*

class AuditorAwareImpl: AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.ofNullable("system")
    }
}