package com.demo.common;

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
public class InterceptorConfig extends WebHandler {

    @Override
    public boolean verify(String token, HandlerMethod handlerMethod) {
        return super.verify(token, handlerMethod);
    }
}
