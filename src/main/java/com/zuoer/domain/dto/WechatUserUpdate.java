package com.zuoer.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.domain.vo.ConfigHouseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class WechatUserUpdate extends SysUser {

    @ApiModelProperty("角色Id")
    private Long roleId;

    @ApiModelProperty("关联房屋")
    private List<ConfigHouseVO> houseList;


}
