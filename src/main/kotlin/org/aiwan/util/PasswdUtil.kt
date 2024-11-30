package org.aiwan.util

import cn.hutool.crypto.SecureUtil

object PasswdUtil {
    fun passwd(salt: String?, passwd: String?): String {
        return SecureUtil.md5(salt + passwd)
    }
}

/** 加密 */
fun String.toMd5(): String {
    return SecureUtil.md5(this)
}

/** 密码 */
fun String.toPassword(salt: String): String {
    return PasswdUtil.passwd(salt, this)
}