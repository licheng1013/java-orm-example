package com.demo.dto;

import lombok.Data;

@Data
public class RoleDto {
    public RoleDto(String roleName, String value) {
        this.roleName = roleName;
        this.value = value;
    }

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色值
     */
    private String value;
}
