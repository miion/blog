package org.mion.blog.common.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

val jsonSerializer: Gson by lazy {
    GsonBuilder()
        .setDateFormat(DateFormats.YYYYMMDDTHHMMSS_ISO.format)
        .create()
}

fun <R : Any> R?.toJSON(): String {
    return this?.let {
        return try {
            jsonSerializer.toJson(this).replace("\r\n", " ")
        } catch (ex: Throwable) {
            """
                {
                    "error": "${ex.message}
                    "type": "${this.javaClass.name}"
                }    
            """.trimIndent()
        }
    } ?: ""
}