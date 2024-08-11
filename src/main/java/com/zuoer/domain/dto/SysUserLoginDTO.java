package com.zuoer.domain.dto;

import com.zuoer.domain.entity.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserLoginDTO extends SysUser {

    @ApiModelProperty("登录角色(owner,housekeeper,admin)")
    private String loginRoleName;
}
