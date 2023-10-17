package com.shop.common;

/**
 * 自定义异常
 * @author lc
 * @since 2023/1/14
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}

