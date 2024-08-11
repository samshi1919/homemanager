package com.zuoer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.entity.PermissionRequest;
import com.zuoer.domain.entity.SysRole;
import com.zuoer.domain.entity.SysUserRole;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.SysUserVO;
import com.zuoer.enums.RequestStatus;
import com.zuoer.enums.UserStatus;
import com.zuoer.mapper.SysUserMapper;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.service.PermissionRequestService;
import com.zuoer.service.SysRoleService;
import com.zuoer.service.SysUserRoleService;
import com.zuoer.service.SysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * (SysUser)表服务实现类
 *
 * @author xm
 * @since 2024-08-10 11:23:32
 */
@Service("sysUserService")
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysRoleService sysRoleService;

    private final SysUserRoleService sysUserRoleService;

    private final PermissionRequestService permissionRequestService;

    @Override
    public IPage<SysUser> queryPage(QueryPageParam queryPageParam) {
        //创建Page对象
        IPage<SysUser> page = new Page<>(queryPageParam.getCurrent(), queryPageParam.getSize());

        //构建条件
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(SysUser::getUpdateTime);
        Map<String, Object> map = (Map<String, Object>) queryPageParam.getParam();
        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (null != map) {
            //构造筛选条件
        }
        return this.baseMapper.selectPage(page, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUserVO login(SysUserLoginDTO sysUserLoginDTO) {
        SysUserVO sysUserVO = new SysUserVO();
        //根据手机号登录，如果账号存在并且状态为1，返回用户信息
        String phoneNumber = sysUserLoginDTO.getPhoneNumber();
        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getPhoneNumber, phoneNumber));
        if (sysUser != null && UserStatus.NORMAL.getCode() == sysUser.getStatus()) {
            //正常状态，查询相关信息返回
            SysUserQuery query = new SysUserQuery();
            query.setUserId(sysUser.getUserId());
            sysUserVO = this.baseMapper.getUserInfo(query);
        } else if (sysUser != null && UserStatus.DISABLED.getCode() == sysUser.getStatus()) {
            //禁用状态
            sysUserVO.setStatus(UserStatus.DISABLED.getCode());
        } else if (sysUser != null && UserStatus.AUDIT.getCode() == sysUser.getStatus()) {
            //审核状态
            sysUserVO.setStatus(UserStatus.AUDIT.getCode());
        } else if (sysUser == null) {
            //账号不存在
            //创建账号
            sysUserLoginDTO.setStatus(UserStatus.AUDIT.getCode());
            this.save(sysUserLoginDTO);
            Long newUserId = sysUserLoginDTO.getUserId();
            String loginRoleName = sysUserLoginDTO.getLoginRoleName();
            //绑定角色
            SysRole sysRole = sysRoleService.getOne(new LambdaQueryWrapper<SysRole>()
                    .eq(SysRole::getRoleName, loginRoleName));
            if (sysRole != null) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(newUserId);
                sysUserRole.setRoleId(sysRole.getRoleId());
                sysUserRoleService.save(sysUserRole);
                //新增权限请求
                PermissionRequest pr = new PermissionRequest();
                pr.setUserId(newUserId);
                pr.setStatus(RequestStatus.PROGRESS.getCode());
                pr.setRoleName(loginRoleName);
                permissionRequestService.save(pr);
                sysUserVO.setStatus(UserStatus.AUDIT.getCode());
            }
        }
        return sysUserVO;

    }
}

