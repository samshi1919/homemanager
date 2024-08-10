package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 广告配置表(ConfigAd)实体类
 *
 * @author xm
 * @since 2024-08-10 17:44:55
 */
@ApiModel("广告配置表实体类")
@Data
public class ConfigAd extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long adId;
    
    @ApiModelProperty("广告类型")
    private String adType;
    
    @ApiModelProperty("资源类型（1：图片 2：视频）")
    private Integer adSourceType;
    
    @ApiModelProperty("广告资源URL")
    private String adSourceUrl;
    
    @ApiModelProperty("链接地址")
    private String adLink;
    
    @ApiModelProperty("0 未启用 1 启用")
    private Integer status;
    

 
}
