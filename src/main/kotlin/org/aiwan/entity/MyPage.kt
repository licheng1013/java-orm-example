package org.aiwan.entity

import com.baomidou.mybatisplus.core.metadata.IPage


data class MyPage<T>(
    var total: Long = 0,
    var list: List<T> = arrayListOf<T>()
)

fun <T> IPage<T>.toPage() = MyPage(this.total, this.records)