package com.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.demo.entity.Admin;


@Mapper
public interface AdminDao extends BaseMapper<Admin> {

}
