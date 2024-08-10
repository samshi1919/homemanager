package com.zuoer.domain.vo;


import com.zuoer.domain.entity.SysRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 角色表(SysRole)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("角色表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysRoleVO extends SysRole {


}
