package org.mion.blog.domain.notification.service

import org.mion.blog.sse.repository.EmitterRepository
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.time.Instant

@Service
class NotificationService(
    private val emitterRepository: EmitterRepository
) {

    fun init(userId: String, lastEventId: String?): SseEmitter {
        val key = generateSseEmitterKey(userId)

        val sseEmitter: SseEmitter = emitterRepository.save(key, SseEmitter(DEFAULT_TIMEOUT))

        sseEmitter.onCompletion {
            emitterRepository.deleteById(key)
        }

        sseEmitter.onTimeout {
            emitterRepository.deleteById(key)
            sseEmitter.complete()
        }

        sseEmitter.onError { throwable ->
//            log.error("")
            sseEmitter.complete()
        }

        send(sseEmitter, key, "init", "Event stream created. userId=${userId}")

        return sseEmitter
    }

    protected fun send(sseEmitter: SseEmitter, key: String, name: String, data: Any) {
        val event = SseEmitter.event()
            .name(name)
            .data(data)
        sseEmitter.send(event)
    }

    protected fun generateSseEmitterKey(userId: String): String {
        return "userId_${Instant.now().toEpochMilli()}"
    }

    companion object {
        const val DEFAULT_TIMEOUT = 30_000L
    }
}