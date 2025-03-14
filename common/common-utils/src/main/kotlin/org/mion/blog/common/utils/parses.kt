package org.mion.blog.common.utils

import java.math.BigDecimal

fun Number?.isZero(): Boolean {
    return try {
        when (this) {
            is Long -> this == 0L
            is Int -> this == 0
            is Float -> this == 0.0f
            is Double -> this == 0.0
            is BigDecimal -> this == BigDecimal(0)
            else -> false
        }
    } catch (ex: Exception) {
        false
    }
}

fun <T : Any> T?.toLongSafely(): Long {
    return try {
        when (this) {
            is Int -> this.toLong()
            is String -> this.toLong()
            is Long -> this
            is BigDecimal -> this.toLong()
            else -> 0L
        }
    } catch (ex: Exception) {
        0L
    }
}

fun <T : Any> T?.toIntSafely(): Int {
    return try {
        when (this) {
            is Int -> this
            is String -> this.toInt()
            is Long -> this.toInt()
            is BigDecimal -> this.toInt()
            else -> 0
        }
    } catch (ex: Exception) {
        0
    }
}