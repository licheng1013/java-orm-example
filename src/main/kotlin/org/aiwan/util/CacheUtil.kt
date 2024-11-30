package org.aiwan.util

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/** 缓存工具类 */
object CacheUtil {
    /** 缓存数据 */
    val dataCache = RateCache(100)

    /** 访问限制 */
    val rateCache = RateLimiter(10)

    /** api限制,如果30秒超过1000请求，后续停止接口访问 */
    val apiCache = RateLimiter(2000, 24, TimeUnit.HOURS)
}


class RateCache(val maxSize: Int = 10) {
    private val cache: LinkedHashMap<String, Any> = object : LinkedHashMap<String, Any>(maxSize, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, Any>?): Boolean {
            return size > maxSize
        }
    }

    fun get(key: String): Any? {
        return cache[key]
    }

    fun set(key: String, value: Any) {
        cache[key] = value
    }

    override fun toString(): String {
        return cache.toString()
    }
}


/** 默认时间是1分钟 */
class RateLimiter(val maxSize: Int, val time: Long = 60, val timeUnit: TimeUnit = TimeUnit.SECONDS) {

    private val accessMap = ConcurrentHashMap<String, Long>()

    init {
        thread {
            while (true) {
                Thread.sleep(timeUnit.toMillis(time))
                accessMap.clear()
            }
        }
    }

    /** 如果进行回调了，那么代表已经达到访问限制了 */
    fun tryAccess(key: String, callback: () -> Unit = {}) {
        val num = accessMap.getOrDefault(key, 0) + 1
        accessMap[key] = num
        if (num >= maxSize) {
            callback()
        }
    }
}


fun main() {
    val cache = RateCache()
    for (i in 1..15) {
        cache.set("key$i", "value$i")
    }
    println("数据:$cache")

    val rateLimiter = RateLimiter(10)
    for (i in 1..15) {
        rateLimiter.tryAccess("test") {
            println("limit$i")
        }
        Thread.sleep(100)
    }
}