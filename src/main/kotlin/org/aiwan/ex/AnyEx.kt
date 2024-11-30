package org.aiwan.ex

import java.math.BigDecimal


fun Any?.toDouble2(): Double {
    return when (this) {
        is Double -> this
        is BigDecimal -> this.toDouble()
        is String -> this.toDouble()
        else -> 0.0
    }
}

fun Any?.toInt2(): Int {
    return when (this) {
        is Int -> this
        is String -> this.trim().toInt()
        else -> 0
    }
}