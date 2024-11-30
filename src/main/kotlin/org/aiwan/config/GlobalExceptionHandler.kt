package org.aiwan.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.aiwan.entity.ResultInfo
import org.aiwan.util.HttpUtil
import org.aiwan.util.MyException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

private val log = KotlinLogging.logger {}

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(MyException::class)
    @ResponseBody
    fun handleMyException(e: MyException): ResultInfo<Any> {
        showInfo("业务异常", e)
        return ResultInfo.fail(e.message ?: "未知异常", code = e.code)
    }

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleException(e: Exception): ResultInfo<Any> {
        // 在这里处理异常，返回统一格式的错误响应
        showInfo("系统异常", e)
        return ResultInfo.fail(e.message ?: "未知异常")
    }

    fun showInfo(title: String, e: Exception) {
        // 业务异常
        log.error(e) {
            """
            $title
            -路径: "${HttpUtil.path}"
            -参数: ${HttpUtil.queryString}
        """.trimIndent()
        }
    }
}