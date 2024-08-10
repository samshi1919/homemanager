package com.zuoer.domain.query;


import com.zuoer.domain.entity.SysUserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 用户角色关系表(SysUserRole)查询对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("用户角色关系表查询对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserRoleQuery extends SysUserRole {


}
