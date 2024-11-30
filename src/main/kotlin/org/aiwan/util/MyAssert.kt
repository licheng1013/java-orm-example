package org.aiwan.util

import org.aiwan.util.MyAssert.isEmpty
import org.aiwan.util.MyAssert.isLength
import org.aiwan.util.MyAssert.isRange
import org.aiwan.util.MyAssert.isTrue

object MyAssert {
    /**  如果为true，则抛出异常 */
    fun isTrue(b: Boolean, msg: String) {
        if (b) {
            throw MyException(msg)
        }
    }

    /**  判断字符传为空 */
    fun isEmpty(s: String?, msg: String) {
        isNull(s, msg)
        if (s == null || s.isBlank()) {
            throw MyException(msg)
        }
    }

    /**  检查字符串长度 */
    fun isLength(s: String, size: Int, msg: String) {
        isNull(s, msg)
        if (s.length != size) {
            throw MyException(msg)
        }
    }

    /**  判断长度是否在范围内，min 和 max 本身都包含在内 例如 min=1, max=3，则长度为1，2，3 都是合法的 */
    fun isRange(s: String, min: Int, max: Int, msg: String) {
        isNull(s, msg)
        if (s.length < min || s.length > max) {
            throw MyException(msg)
        }
    }

    /**  判断是否为空抛出错误 */
    fun isNull(o: Any?, msg: String) {
        if (o == null) {
            throw MyException(msg)
        }
    }

    fun isZero(id: Int?, msg: String) {
        if (id == 0 || id == null) {
            throw MyException(msg)
        }
    }

    fun isFalse(f: Boolean, s: String) {
        if (!f) {
            throw MyException(s)
        }
    }

    fun error(msg: String){
        throw MyException(msg)
    }

}

fun main() {
    // 测试
    isTrue(false, "true")
    isEmpty("asdf", "空")
    isLength("123", 3, "长度")
    isRange("1234", 3, 5, "范围")
    println("通过...")
}
