package org.aiwan.config

import org.aiwan.entity.ResultInfo
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@ControllerAdvice
class ApiResponseAdvice : ResponseBodyAdvice<Any> {
    /** 判断哪些响应需要被包装 */
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }
    /** 判断包装 */
    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any {
        // 不知道为什么不能正确序列化
        if (body is ResultInfo<*>) {
            return body
        }
        // 否则，将原始响应包装在ApiResponse中
        return ResultInfo.ok(body)
    }
}