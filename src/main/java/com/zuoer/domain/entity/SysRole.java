package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 角色表(SysRole)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("角色表实体类")
@Data
public class SysRole extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long roleId;
    
    @ApiModelProperty("角色名")
    private String roleName;
    

 
}
