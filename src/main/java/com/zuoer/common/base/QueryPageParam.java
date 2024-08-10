package com.zuoer.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ck
 * @date 2022/5/24 11:25
 */
@Data
@ApiModel("PagingRequestParam")
public class QueryPageParam<T> {

     @ApiModelProperty(value = "当前页数",required = true)
     private Integer current;

     @ApiModelProperty(value = "每页多少条数据",required = true)
     private Integer size;

     @ApiModelProperty("查询参数: " +
             "status (0.Pending 1.Incomplete 2.Accepted 3.Answered 4.Completed 5 Rejected)" +
             "keyword( 多字段模糊查询)" +
             "myQuestion (true))" +
             "myAnswer (true)")
     private T param;

}
