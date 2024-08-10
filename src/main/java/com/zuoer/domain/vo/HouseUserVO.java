package com.zuoer.domain.vo;


import com.zuoer.domain.entity.HouseUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 房屋用户关系表(HouseUser)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("房屋用户关系表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseUserVO extends HouseUser {


}
