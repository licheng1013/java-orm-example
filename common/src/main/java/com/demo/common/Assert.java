package com.demo.common;

import cn.hutool.core.util.NumberUtil;

public class Assert {

    /** 判断空 */
    public static void nullOrEmpty(Object object, String message) {
        if (object == null) {
            throw new ServiceException(message);
        }
        if (object instanceof String str) {
            if (str.trim().isBlank()) {
                throw new ServiceException(message);
            }
        }
    }

    /** 判断长度 */
    public static void lenght(Object object, int lenght, String message) {
        if (object == null) {
            throw new ServiceException(message);
        }
        if (object.toString().length() != lenght) {
            throw new ServiceException(message);
        }
    }

    /**
     * 判断数字范围
     */
    public static <T extends Number> void range(T num, T min, T max, String message) {
        if (num == null) {
            throw new ServiceException(message);
        }
        if (num.doubleValue() < min.doubleValue() || num.doubleValue() > max.doubleValue()) {
            throw new ServiceException(message);
        }
    }


    /** 判断是否为true */
    public static void isTrue(boolean bool, String message) {
        if (bool) {
            throw new ServiceException(message);
        }
    }



    public static void main(String[] args) {
        range(2, 1, 2, "aa");
    }

    public static void number(String userId, String message) {
        if (!NumberUtil.isNumber(userId)) {
            throw new ServiceException(message);
        }
    }
}
