package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 装修阶段类型配置表(ConfigFitmentCategory)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("装修阶段类型配置表实体类")
@Data
public class ConfigFitmentCategory extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long categoryId;
    
    @ApiModelProperty("需求表、定稿平面...")
    private String categoryName;
    
    @ApiModelProperty("装修阶段 1：设计 2：施工 3：维保")
    private Integer fitmentStage;
    

 
}
