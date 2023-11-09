package com.demo.common;

import cn.hutool.crypto.SecureUtil;

public class PasswordUtil {

    /** 密码+盐md5 */
    public static String password(String password,String salt) {
        return SecureUtil.md5(password+salt);
    }

    public static void main(String[] args) {
        System.out.println(password("123456", "7702151f-f8e6-47d7-82c7-7a8ec21c16b1"));
    }
}
