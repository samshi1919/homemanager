package com.zuoer.domain.query;


import com.zuoer.domain.entity.SysConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (SysConfig)查询对象
 *
 * @author xm
 * @since 2024-08-11 21:13:34
 */
@ApiModel("")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysConfigQuery extends SysConfig {


}
