package org.mion.blog.common.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

val <R: Any> R.logger get() = lazy { LoggerFactory.getLogger(this::class.java) }
val <R: Any> R.log: Logger get() = logger.value

fun Logger.info(obj: Any?) = obj.let { this.info(obj.toString()) }
fun Logger.warn(obj: Any?) = obj.let { this.warn(obj.toString()) }
fun Logger.error(obj: Any?) = obj.let { this.error(obj.toString()) }
fun Logger.debug(obj: Any?) = obj.let { this.debug(obj.toString()) }