package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * (SysConfig)实体类
 *
 * @author xm
 * @since 2024-08-11 21:13:34
 */
@ApiModel("")
@Data
public class SysConfig extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long configId;
    
    @ApiModelProperty("配置key")
    private String configKey;
    
    @ApiModelProperty("配置值")
    private String configValue;
    

 
}
