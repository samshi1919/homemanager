package com.zuoer.domain.query;


import com.zuoer.domain.entity.FitmentCategoryItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 装修类型项目表(FitmentCategoryItem)查询对象
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("装修类型项目表查询对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FitmentCategoryItemQuery extends FitmentCategoryItem {


}
