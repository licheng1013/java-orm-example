package com.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdminDto {
    private Long userId;
    private String userName;
    private String realName;
    private List<RoleDto> roles;
}
