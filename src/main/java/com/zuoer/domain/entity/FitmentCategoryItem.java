package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 装修类型项目表(FitmentCategoryItem)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("装修类型项目表实体类")
@Data
public class FitmentCategoryItem extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long itemId;
    
    @ApiModelProperty("房屋id")
    private Long houseId;
    
    @ApiModelProperty("文件类型id")
    private Long categoryId;
    
    @ApiModelProperty("项目日期")
    private Date createDate;
    
    @ApiModelProperty("施工说明")
    private String constructionDesc;
    
    @ApiModelProperty("建议")
    private String suggestion;
    
    @ApiModelProperty("项目检查日期")
    private Date checkDate;
    
    @ApiModelProperty("检查说明")
    private String checkDesc;
    

 
}
