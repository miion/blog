package org.mion.blog.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.io.IOException

@Component
class ChatWebSocketHandler: TextWebSocketHandler() {

    private val clientSession = mutableMapOf<String, WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        clientSession[session.id] = session
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        clientSession.forEach { (key: String, value: WebSocketSession) ->
            try {
                value.sendMessage(message)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        clientSession.remove(session.id)
    }

}