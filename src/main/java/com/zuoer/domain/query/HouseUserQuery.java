package com.zuoer.domain.query;


import com.zuoer.domain.entity.HouseUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 房屋用户关系表(HouseUser)查询对象
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("房屋用户关系表查询对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseUserQuery extends HouseUser {


}
