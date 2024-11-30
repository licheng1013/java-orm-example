package org.aiwan.util

import jakarta.servlet.http.HttpServletRequest
import lombok.experimental.UtilityClass
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

/**
 * 必须在web环境使用,否则会出现空指针异常
 */
object HttpUtil {
    /**
     * @return 当前请求的路径
     */
    val path: String
        get() = this.httpServletRequest.requestURI


    /**
     * 获取HttpServletRequest
     */
    val httpServletRequest: HttpServletRequest
        get() = (Objects.requireNonNull<RequestAttributes>(RequestContextHolder.getRequestAttributes()) as ServletRequestAttributes).request

    /**
     * 获取请求参数
     */
    val paramMap: MutableMap<String, Array<String>>
        get() {
            val request: HttpServletRequest = this.httpServletRequest
            return request.parameterMap
        }

    /**
     * web环境使用
     */
    fun getHeader(name: String): String {
        return this.httpServletRequest.getHeader(name) ?: ""
    }

    fun token() = getHeader(tokenKey)

    /** 路径参数?后面的 */
    val queryString: String? get() = this.httpServletRequest.queryString

    /** 获取完整路径 */
    val url: String get() = this.httpServletRequest.requestURL.toString()

    /**
     * 获取请求类型GET,POST
     */
    val method: String
        get() = this.httpServletRequest.method


    var tokenKey: String = "Authorization"

    /**
     * 获取用户id
     */
    val userId: Int
        get() {
            val token: String = getHeader(tokenKey)
            val userId = TokenUtil.getUserId(token)
            return userId.toInt()
        }
}
