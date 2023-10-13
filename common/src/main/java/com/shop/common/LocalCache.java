package com.shop.common;


import org.springframework.stereotype.Component;

@Component
public class LocalCache implements Cache{
    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }
}
