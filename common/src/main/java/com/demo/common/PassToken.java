package com.demo.common;

import java.lang.annotation.*;

/**
 * 排除需要登入的接口
 * @author lc
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface PassToken {
}
