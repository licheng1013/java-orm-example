package com.shop.controller;

import com.shop.common.PassToken;
import com.shop.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 注释
 */
@RestController
@RequestMapping("/user")
@PassToken
public class UserController {

    /**
     * login
     */
    @PostMapping("/login")
    public Object login(){
        return R.okMsg("Hello World");
    }


    @GetMapping("/list")
    public Object list(String name, HttpServletRequest request){
        return R.okData(name+request.getHeader("token"));
    }

    @GetMapping("/list2")
    public Object list2(){
        return R.okData("list2");
    }

}
