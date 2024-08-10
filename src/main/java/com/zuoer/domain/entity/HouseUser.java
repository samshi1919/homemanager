package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 房屋用户关系表(HouseUser)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("房屋用户关系表实体类")
@Data
public class HouseUser extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long houseUserId;
    
    @ApiModelProperty("房屋id")
    private Long houseId;
    
    @ApiModelProperty("用户id")
    private Long userId;
    
    @ApiModelProperty("1：管理员 2：管家 3：业主")
    private Integer houseRole;
    

 
}
