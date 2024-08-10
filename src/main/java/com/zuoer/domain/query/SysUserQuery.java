package com.zuoer.domain.query;


import com.zuoer.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (SysUser)查询对象
 *
 * @author xm
 * @since 2024-08-10 11:23:32
 */
@ApiModel("")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserQuery extends SysUser {


}
