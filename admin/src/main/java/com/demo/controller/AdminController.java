package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.common.PassToken;
import com.demo.common.R;
import com.demo.dto.PageDto;
import com.demo.entity.Admin;
import com.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 注释
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService vService;

    @PassToken
    @PostMapping("/login")
    public Object login(@RequestBody Admin admin){
        return R.okData(vService.login(admin));
    }



    /**
     * @Param(size=1)
     */
    @PassToken
    @GetMapping("/list") //分页
    public Object list(Page<Admin> page, Admin v) {
        return R.okData(PageDto.warp(vService.page(page, new LambdaQueryWrapper<>(v).orderByDesc(Admin::getCreateTime))));
    }

    @PassToken
    @GetMapping("/index")
    public Object index() {
        return R.okMsg("Hello World");
    }


    @GetMapping("/userInfo")
    public Object userInfo() {
        return R.okData(vService.userInfo());
    }



    @PostMapping("/delete") //多条删除 => 1,2,3
    public Object deleteAll(@RequestBody ArrayList<String> ids){
        //vService.removeByIds(ids);
        return R.okMsg("删除所有成功(演示不允许删除)!");
    }

    @PostMapping("/insert") //插入
    public Object insert(@RequestBody Admin v){
        vService.save(v);
        return R.okMsg("插入成功!");
    }

    @PostMapping("/update") //修改
    public Object update(@RequestBody Admin v){
        vService.updateById(v);
        return R.okMsg("修改成功!");
    }


}
