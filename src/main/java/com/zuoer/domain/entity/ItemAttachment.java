package com.zuoer.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.*;
import lombok.Data;
import java.util.Date;
import com.zuoer.common.base.MyBaseModel;

/**
 * 装修项目文件表(ItemAttachment)实体类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("装修项目文件表实体类")
@Data
public class ItemAttachment extends MyBaseModel  {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    private Long fileId;
    
    @ApiModelProperty("项目id")
    private Long itemId;
    
    @ApiModelProperty("0:不是检查 1:是检查")
    private Integer isCheck;
    
    @ApiModelProperty("原始文件名")
    private String originalFileName;
    
    @ApiModelProperty("")
    private String saveFileName;
    
    @ApiModelProperty("")
    private String savePath;
    

 
}
