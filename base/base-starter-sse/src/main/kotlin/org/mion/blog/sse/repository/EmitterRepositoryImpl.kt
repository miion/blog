package org.mion.blog.sse.repository

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap


@Component
class EmitterRepositoryImpl : EmitterRepository {

    private val emitters: Map<String, SseEmitter> = ConcurrentHashMap()

    override fun save(key: String, sseEmitter: SseEmitter): SseEmitter {
        emitters.plus(key to sseEmitter)
        return sseEmitter
    }

    override fun findAllEmitterStartWithByUserId(userId: String): Map<String, SseEmitter> {
        return emitters.filter {
            it.key.startsWith(userId)
        }
    }

    override fun deleteById(key: String) {
        emitters.minus(key)
    }

}