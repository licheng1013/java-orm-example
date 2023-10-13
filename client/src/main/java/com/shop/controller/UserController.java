package com.shop.controller;

import com.shop.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Object login(){
        return R.okMsg("Hello World");
    }

    @GetMapping("/list")
    public Object list(){
        return R.okData("list");
    }

}
