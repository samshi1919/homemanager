package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.PermissionRequest;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.PermissionRequestVO;
import java.util.List;

/**
 * 账号权限申请表(PermissionRequest)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
public interface PermissionRequestService extends IService<PermissionRequest> {

    /**
     * PermissionRequest 分页列表
     *
     * @return
     */   
    IPage<PermissionRequest> queryPage(QueryPageParam queryPageParam);

}

