package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.dto.WechatUserUpdate;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.SysUserVO;

import java.util.List;

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

    /**
     * 获取用户信息
     * @param phoneNumber
     * @return
     */
    SysUserVO getUserInfo(String phoneNumber);


    /**
     * 获取用户列表
     * @return
     */
    List<SysUserVO> getUserList(SysUserQuery query);

    /**
     * 更新小程序用户信息
     *
     * @param userUpdate
     */
    void updateWechatUserInfo(WechatUserUpdate userUpdate);


}

