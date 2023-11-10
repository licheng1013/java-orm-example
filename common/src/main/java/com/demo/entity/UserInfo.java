package com.demo.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;


@Data
public class UserInfo {

    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** 名称 */
    private String name;
    /** 昵称 */
    private String nickname;
    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    
}