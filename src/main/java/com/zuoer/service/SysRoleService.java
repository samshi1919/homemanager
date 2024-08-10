package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.SysRole;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.SysRoleVO;
import java.util.List;

/**
 * 角色表(SysRole)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * SysRole 分页列表
     *
     * @return
     */   
    IPage<SysRole> queryPage(QueryPageParam queryPageParam);

}

