package org.mion.blog.dto

data class SocketMessageDto(
    val text: String,
    val sender: String,
    val type: String,
)