package com.demo.common;

public interface Cache {
    void set(String key, String value);
    String get(String key);

}
