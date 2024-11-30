package org.aiwan.util

/**
 * 异常处理器
 */
class MyException(message: String, val code: Int = -1) : RuntimeException(message)