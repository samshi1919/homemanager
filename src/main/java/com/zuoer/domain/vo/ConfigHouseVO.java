package com.zuoer.domain.vo;


import com.zuoer.domain.entity.ConfigHouse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 房屋配置表(ConfigHouse)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("房屋配置表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigHouseVO extends ConfigHouse {

    @ApiModelProperty("1：管理员 2：管家 3：业主")
    private Integer houseRole;
}
