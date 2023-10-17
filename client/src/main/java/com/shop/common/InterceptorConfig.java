package com.shop.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lc
 */
@Configuration
@Slf4j
public class InterceptorConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest rt, HttpServletResponse re, Object handler) {
        //排除静态资源
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        if (isSikp(handlerMethod)) {
            return true;
        }
        String token = rt.getHeader("token");
        // 这里进行认证处理
        log.info("认证失败! {}", token);
        throw new ServiceException("认证失败");
    }

    public boolean isSikp(HandlerMethod method) {
        PassToken passToken = method.getBeanType().getAnnotation(PassToken.class);
        if (passToken != null) {
            return true;
        }
        PassToken token = method.getMethodAnnotation(PassToken.class);
        return token != null;
    }
}
