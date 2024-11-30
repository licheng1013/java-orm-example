package org.aiwan.ex

import java.text.SimpleDateFormat

// 转换时间戳为 yyyy-MM-dd HH:mm:ss 格式
fun Long.toDateTime(): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date(this))
}