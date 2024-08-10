package com.zuoer.domain.vo;


import com.zuoer.domain.entity.PermissionRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 账号权限申请表(PermissionRequest)VO对象
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@ApiModel("账号权限申请表VO对象")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionRequestVO extends PermissionRequest {


}
