package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 用户表(SysUser)实体类
 *
 * @author xm
 * @since 2024-08-10 17:43:56
 */
@ApiModel("用户表实体类")
@Data
public class SysUser extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long userId;
    
    @ApiModelProperty("微信号")
    private String wechatAccount;
    
    @ApiModelProperty("微信名")
    private String wechatName;
    
    @ApiModelProperty("微信头像")
    private String wechatAvatar;
    
    @ApiModelProperty("")
    private String openId;
    
    @ApiModelProperty("手机号")
    private String phoneNumber;
    
    @ApiModelProperty("上一次登录时间")
    private Date lastLoginTime;
    
    @ApiModelProperty("0 审核中 1正常 2禁用")
    private Integer status;
    

 
}
