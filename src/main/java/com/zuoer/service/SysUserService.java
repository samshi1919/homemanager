package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.SysUserVO;

/**
 * (SysUser)表服务接口
 *
 * @author xm
 * @since 2024-08-10 11:23:32
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * SysUser 分页列表
     *
     * @return
     */
    IPage<SysUser> queryPage(QueryPageParam queryPageParam);

    /**
     * 用户登录
     *
     * @param sysUserLoginDTO
     * @return
     */
    SysUserVO login(SysUserLoginDTO sysUserLoginDTO);


}

