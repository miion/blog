package org.mion.blog.controller

import org.mion.blog.dto.SocketMessageDto
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val template: SimpMessagingTemplate
) {

    @MessageMapping("/messages")
    fun send(@RequestBody socketMessageDto: SocketMessageDto): SocketMessageDto {
        template.convertAndSend("/sub/message", socketMessageDto.text)
        return socketMessageDto
    }

    @MessageMapping("/alarm")
    fun send(): SocketMessageDto {
        val message = SocketMessageDto(
            text = "alarm!!",
            sender = "admin",
            type = "ALARM",
        )
        template.convertAndSend("/sub/alarm", message)
        return message
    }

}