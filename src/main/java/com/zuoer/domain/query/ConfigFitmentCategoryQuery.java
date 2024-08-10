package com.zuoer.domain.query;


import com.zuoer.domain.entity.ConfigFitmentCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 装修阶段类型配置表(ConfigFitmentCategory)查询对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("装修阶段类型配置表查询对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigFitmentCategoryQuery extends ConfigFitmentCategory {


}
