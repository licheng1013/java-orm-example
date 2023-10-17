package com.shop.common;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT的封装用于更易用
 * @author lc
 */
public class TokenUtil  {
    /** 密钥串 **/
    public static String SECRET_KEY = "YOUR_SECRET_KEY";
    private static final  String USER_ID_KEY = "USER_ID";
    private static final  String EXPIRE_TIME_KEY = "EXPIRE_TIME";
    /**
     * 获取Token
     */
    public static String getToken(Serializable userId){
        Map<String, Object> map = new HashMap<>();
        map.put(USER_ID_KEY, userId);
        map.put(EXPIRE_TIME_KEY, System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3);
        return JWTUtil.createToken(map, SECRET_KEY.getBytes());
    }

    /**
     * 获取用户id
     */
    public static String getUserId(String token){
        JWT jwt = JWTUtil.parseToken(token);
        if (!JWTUtil.verify(token, SECRET_KEY.getBytes())) {
            throw new ServiceException("无效Token!");
        }
        Object payload = jwt.getPayload(EXPIRE_TIME_KEY);
        System.out.println(payload);
        if (payload == null || System.currentTimeMillis() > Long.parseLong(payload.toString())) {
            throw new ServiceException("登入失效!");
        }
        return jwt.getPayload(USER_ID_KEY).toString();
    }

    public static void main(String[] args) {
        //测试
        String token = getToken(123456);
        System.out.println(token);
        String userId = getUserId(token);
        System.out.println(userId);
    }
}
