package org.mion.blog.common.utils

import kotlin.reflect.KClass

inline fun <reified T : Enum<T>> translate(type: String?, default: T): T {
    return type?.let {
        try {
            java.lang.Enum.valueOf(T::class.java, it)
        } catch (e: IllegalArgumentException) {
            default
        }
    } ?: default
}

inline fun <reified T : Enum<T>, reified R : Enum<R>> T.toEnum(enumType: KClass<R>): R? {
    return try {
        java.lang.Enum.valueOf(enumType.java, this.name)
    } catch (e: IllegalArgumentException) {
        null
    }
}

inline fun <reified T : Enum<T>> String?.toEnum(defaultValue: T): T = translate(this, defaultValue)