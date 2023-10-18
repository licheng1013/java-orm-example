package com.demo.controller;

import com.demo.common.PassToken;
import com.demo.common.R;
import com.demo.entity.Admin;
import com.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @PassToken
    @PostMapping("/login")
    public Object login(Admin admin){
        return R.okData(adminService.login(admin));
    }


    @PassToken
    @GetMapping("/index")
    public Object index(){
        return R.okMsg("Hello World");
    }


    @GetMapping
    public Object userInfo(){
        return R.okData(adminService.userInfo());
    }

}