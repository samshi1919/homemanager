package com.zuoer.domain.vo;


import com.zuoer.domain.entity.ConfigAd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 广告配置表(ConfigAd)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:44:55
 */
@ApiModel("广告配置表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigAdVO extends ConfigAd {


}
