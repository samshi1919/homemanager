package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 房屋配置表(ConfigHouse)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@ApiModel("房屋配置表实体类")
@Data
public class ConfigHouse extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long houseId;
    
    @ApiModelProperty("房屋名")
    private String houseName;
    
    @ApiModelProperty("地址")
    private String address;
    
    @ApiModelProperty("经纬度")
    private String gpsLatLon;
    
    @ApiModelProperty("直播链接")
    private String liveStreamingLink;

}
