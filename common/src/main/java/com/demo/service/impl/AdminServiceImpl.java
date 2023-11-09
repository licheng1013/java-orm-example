package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.*;
import com.demo.dao.AdminDao;
import com.demo.dto.AdminDto;
import com.demo.entity.Admin;
import com.demo.service.AdminService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    @Override
    public Object login(Admin admin) {
        String errorMsg = "账号或密码错误";
        Assert.nullOrEmpty(admin.getUserName(), errorMsg);
        Assert.nullOrEmpty(admin.getPassword(), errorMsg);

        LambdaQueryWrapper<Admin> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(Admin::getUserName, admin.getUserName());

        Admin one = getOne(lambdaQuery);
        Assert.nullOrEmpty(one, errorMsg);
        String password = PasswordUtil.password(admin.getPassword(), one.getSalt());
        if (!password.equals(one.getPassword())){
            throw new ServiceException(errorMsg);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", TokenUtil.getToken(one.getId()));
        return map;
    }

    @Override
    public Object userInfo() {
        AdminDto dto = new AdminDto();
        dto.setRealName("管理员");
        dto.setUserName("管理员");
        dto.setUserId(getUserId());
        return dto;
    }


    private Long getUserId(){
        String token = HttpServletUtil.getHeader(WebHandler.tokenKey);
        String userId = TokenUtil.getUserId(token);
        Assert.number(userId,"验证失败");
        return Long.parseLong(userId);
    }


}
