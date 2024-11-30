package org.aiwan.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class AuthorizeConfig : WebMvcConfigurer {

    @Autowired
    private lateinit var interceptorConfig: InterceptorConfig

    override fun addInterceptors(registry: InterceptorRegistry) {
        // 拦截所有路径
        registry.addInterceptor(interceptorConfig).addPathPatterns("/**")
    }
}