package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.Admin;

public interface AdminService extends IService<Admin> {

    Object login(Admin admin);

    Object userInfo();

}
