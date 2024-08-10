package com.zuoer.domain.vo;


import com.zuoer.domain.entity.ItemAttachment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 装修项目文件表(ItemAttachment)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("装修项目文件表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemAttachmentVO extends ItemAttachment {


}
