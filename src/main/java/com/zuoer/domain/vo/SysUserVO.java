package com.zuoer.domain.vo;


import com.zuoer.domain.entity.ConfigHouse;
import com.zuoer.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

import java.util.List;

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

    @ApiModelProperty("角色")
    private List<String> roleNames;

    @ApiModelProperty("关联房屋")
    private List<ConfigHouse> houseList;


}
