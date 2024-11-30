package org.aiwan.ex

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper

/** 使用 Book() */
fun <T : Any> T.toUWrapper() = KtUpdateWrapper(this.javaClass)

/** 使用 Book() */
fun <T : Any> T.toQWrapper() = KtQueryWrapper(this.javaClass)

/** 使用自己作为查询条件，条件为不等null的 */
fun <T : Any> T.toQW() = KtQueryWrapper(this)

/** 使用自己作为修改条件，条件为不等null的  */
fun <T : Any> T.toUW() = KtUpdateWrapper(this)