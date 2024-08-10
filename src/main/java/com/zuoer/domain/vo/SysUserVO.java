package com.zuoer.domain.vo;


import com.zuoer.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (SysUser)VO对象
 *
 * @author xm
 * @since 2024-08-10 11:23:31
 */
@ApiModel("")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserVO extends SysUser {


}
