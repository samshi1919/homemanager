package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.SysUserRole;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.SysUserRoleVO;
import java.util.List;

/**
 * 用户角色关系表(SysUserRole)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * SysUserRole 分页列表
     *
     * @return
     */   
    IPage<SysUserRole> queryPage(QueryPageParam queryPageParam);

}

