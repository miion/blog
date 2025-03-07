package org.mion.blog.sse.repository

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

interface EmitterRepository {

    fun save(key: String, sseEmitter: SseEmitter): SseEmitter
    fun findAllEmitterStartWithByUserId(userId: String): Map<String, SseEmitter>
    fun deleteById(key: String)
}