package org.mion.blog.common.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlin.reflect.KClass

val jsonDeserializer: Gson by lazy {
    GsonBuilder()
        .create()
}

fun <R : Any> String?.fromJSON(kClass: KClass<R>): R? = this?.let {
    jsonDeserializer.fromJson(it, kClass.java)
}