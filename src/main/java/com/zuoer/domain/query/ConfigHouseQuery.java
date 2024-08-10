package com.zuoer.domain.query;


import com.zuoer.domain.entity.ConfigHouse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 房屋配置表(ConfigHouse)查询对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("房屋配置表查询对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigHouseQuery extends ConfigHouse {


}
