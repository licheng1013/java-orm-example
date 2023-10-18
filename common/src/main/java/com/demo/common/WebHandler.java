package com.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lc
 */
@Slf4j
public abstract class WebHandler implements HandlerInterceptor {
    public static String tokenKey = "Authorization";


    /** 对于一些静态资源和token排除 */
    @Override
    public boolean preHandle(HttpServletRequest rt, HttpServletResponse re, Object handler) {
        //排除静态资源
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        if (isSikp(handlerMethod)) {
            return true;
        }
        String token = rt.getHeader(tokenKey);
        // 这里进行认证处理
        log.info("认证令牌! {}", token);
        if (verify(token, handlerMethod)) {
            return true;
        }
        throw new ServiceException("认证失败");
    }

    private boolean isSikp(HandlerMethod method) {
        PassToken passToken = method.getBeanType().getAnnotation(PassToken.class);
        if (passToken != null) {
            return true;
        }
        PassToken token = method.getMethodAnnotation(PassToken.class);
        return token != null;
    }

    /** 默认验证方法，当返回false时，抛出验证失败 */
    public boolean verify(String token, HandlerMethod handlerMethod){
        return true;
    }

}
