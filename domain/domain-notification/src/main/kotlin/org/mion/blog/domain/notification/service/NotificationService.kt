package org.mion.blog.domain.notification.service

import org.mion.blog.common.utils.log
import org.mion.blog.domain.notification.constants.SseEventName
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

        val sseEmitter: SseEmitter = emitterRepository.save(key, SseEmitter(DEFAULT_TIMEOUT)).apply {
            this.onCompletion {
                emitterRepository.deleteById(key)
            }
            this.onTimeout {
                this.complete()
            }
            this.onError { throwable ->
                log.warn("Errors on sseEmitter. $key", throwable)
                this.complete()
            }
        }

        send(sseEmitter, key, SseEventName.INIT.name.lowercase(), "userId=${userId}")

        return sseEmitter
    }

    fun sendEvent() {
        val emitters = emitterRepository.findAll()
        emitters.entries.forEach {
            send(it.value, it.key, SseEventName.NOTIFICATION.name.lowercase(), "new event")
        }
    }

    protected fun send(sseEmitter: SseEmitter, key: String, name: String, data: Any) {
        val event = SseEmitter.event()
            .name(name)
            .data(data)
        try {
            sseEmitter.send(event)
        } catch (ex: Exception) {
            log.warn("Errors on sseEmitter.send. $key / $event", ex)
            sseEmitter.complete()
        }
    }

    protected fun generateSseEmitterKey(userId: String): String {
        return "userId_${Instant.now().toEpochMilli()}"
    }

    companion object {
        const val DEFAULT_TIMEOUT = 30 * 1000L
    }
}