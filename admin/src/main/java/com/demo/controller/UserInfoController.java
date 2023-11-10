package com.demo.controller;

import com.demo.common.R;
import com.demo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.entity.UserInfo;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private UserInfoService vService;

    @GetMapping("/list") //分页
    public Object list(Page<UserInfo> page,UserInfo v){
        return R.okData(PageDto.warp(vService.page(page, new LambdaQueryWrapper<>(v).orderByDesc(UserInfo::getCreateTime))));
    }

    @PostMapping("/delete") //多条删除 => 1,2,3
    public Object deleteAll(@RequestBody ArrayList<String> ids){
        vService.removeByIds(ids);
        return R.okMsg("删除所有成功!");
    }

    @PostMapping("/insert") //插入
    public Object insert(@RequestBody UserInfo v){
        vService.save(v);
        return R.okMsg("插入成功!");
    }

    @PostMapping("/update") //修改
    public Object update(@RequestBody UserInfo v){
        vService.updateById(v);
        return R.okMsg("修改成功!");
    }
}
