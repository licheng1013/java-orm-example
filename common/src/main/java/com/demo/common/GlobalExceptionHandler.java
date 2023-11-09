package com.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 *
 * @author lc
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 ServiceException 异常
     */
    @ExceptionHandler(ServiceException.class)
    public R<String> doHandleServiceException(ServiceException e) {
        log.info("请求参数: {}",HttpServletUtil.getParamMap());
        log.info("请求路径: {}",HttpServletUtil.getPath());
        //log.info("请求体: {}",HttpServletUtil.getBody());
        log.info("错误信息:", e);
        return R.fail(e.getMessage());
    }

    /**
     * 处理 Exception 异常
     */
    @ExceptionHandler(Exception.class)
    public R<String> doHandleServiceException(Exception e) {
        e.printStackTrace();
        return R.fail("系统繁忙");
    }
}
