package com.zuoer.domain.vo;


import com.zuoer.domain.entity.ConfigFitmentCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 装修阶段类型配置表(ConfigFitmentCategory)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("装修阶段类型配置表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigFitmentCategoryVO extends ConfigFitmentCategory {


}
