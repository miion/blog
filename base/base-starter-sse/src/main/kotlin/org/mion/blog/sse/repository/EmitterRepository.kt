package org.mion.blog.sse.repository

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

interface EmitterRepository {

    fun findAll(): Map<String, SseEmitter>
    fun findAllEmitterStartWithByUserId(userId: String): Map<String, SseEmitter>

    fun save(key: String, sseEmitter: SseEmitter): SseEmitter
    fun deleteById(key: String)
}