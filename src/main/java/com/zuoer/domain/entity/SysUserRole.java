package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 用户角色关系表(SysUserRole)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("用户角色关系表实体类")
@Data
public class SysUserRole extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long userRoleId;
    
    @ApiModelProperty("用户id")
    private Long userId;
    
    @ApiModelProperty("角色id")
    private Long roleId;
    

 
}
