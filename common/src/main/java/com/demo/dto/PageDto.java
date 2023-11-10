package com.demo.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 分页包装器
 */
public class PageDto<T> {
    public List<T> list;
    public long total;
    public static <T> PageDto warp(Page<T> page) {
        PageDto pageDto = new PageDto();
        pageDto.list = page.getRecords();
        pageDto.total = page.getTotal();
        return pageDto;
    }
}

