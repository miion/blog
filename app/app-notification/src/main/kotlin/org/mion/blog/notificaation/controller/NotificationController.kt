package org.mion.blog.notificaation.controller

import org.mion.blog.domain.notification.service.NotificationService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
class NotificationController(
    private val notificationService: NotificationService
) {

    @GetMapping("/subscribe", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun subscribe(
        @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") lastEventId: String
    ): SseEmitter {
        return notificationService.init("mion", lastEventId)
    }

}