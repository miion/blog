package org.mion.blog.sse.repository

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap


@Component
class EmitterRepositoryImpl : EmitterRepository {

    private val emitters = ConcurrentHashMap<String, SseEmitter>()

    override fun save(key: String, sseEmitter: SseEmitter): SseEmitter {
        emitters[key] = sseEmitter
        return sseEmitter
    }

    override fun findAll(): Map<String, SseEmitter> {
        return emitters
    }

    override fun findAllEmitterStartWithByUserId(userId: String): Map<String, SseEmitter> {
        return emitters.filter {
            it.key.startsWith(userId)
        }
    }

    override fun deleteById(key: String) {
        emitters.remove(key)
    }

}