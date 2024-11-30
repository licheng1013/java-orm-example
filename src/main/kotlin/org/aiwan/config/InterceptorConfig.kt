package org.aiwan.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.aiwan.util.CacheUtil
import org.aiwan.util.HttpUtil
import org.aiwan.util.MyException
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor

@Configuration
class InterceptorConfig : HandlerInterceptor {
    private val log = LoggerFactory.getLogger(InterceptorConfig::class.java)


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        CacheUtil.apiCache.tryAccess("api-limit") {
            throw MyException("访问频繁")
        }
        request.setAttribute("startTime", System.currentTimeMillis())
        // 排除静态资源
        if (handler !is HandlerMethod) {
            return true
        }

        handler.getMethodAnnotation(PassToken::class.java)?.let {
            return true
        }

        //val userId = HttpUtil.userId

        handler.getMethodAnnotation(UserRole::class.java)?.let {
            // 这里是需要获取的用户类型,暂时写死
//            val userRol = user.toRole()
//            if (userRol != it.userType) {
//                throw MyException("用户权限不足")
//            }
        }
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val startTime = request.getAttribute("startTime") as Long
        val endTime = System.currentTimeMillis()
        val executeTime = endTime - startTime
        val formattedExecuteTime = String.format("%10d", executeTime)
        val method = request.method
        val methodWithColor = String.format("%5s", "\u001B[34m$method\u001B[0m") // Blue text color
        val urlPat = request.requestURI
        log.info("${formattedExecuteTime}ms $methodWithColor \"$urlPat\"")
    }
}