package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 账号权限申请表(PermissionRequest)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("账号权限申请表实体类")
@Data
public class PermissionRequest extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long requestId;
    
    @ApiModelProperty("用户id")
    private Long userId;
    
    @ApiModelProperty("申请角色名")
    private String roleName;
    
    @ApiModelProperty("0：申请中 1：申请成功 2：拒绝")
    private Integer status;
    

 
}
