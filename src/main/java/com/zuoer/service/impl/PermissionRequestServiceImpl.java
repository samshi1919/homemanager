package com.zuoer.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.domain.entity.SysRole;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.domain.entity.SysUserRole;
import com.zuoer.enums.RequestStatus;
import com.zuoer.enums.UserStatus;
import com.zuoer.mapper.PermissionRequestMapper;
import com.zuoer.domain.entity.PermissionRequest;
import com.zuoer.service.PermissionRequestService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zuoer.service.SysRoleService;
import com.zuoer.service.SysUserRoleService;
import com.zuoer.service.SysUserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 账号权限申请表(PermissionRequest)表服务实现类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@Service("permissionRequestService")
@RequiredArgsConstructor
public class PermissionRequestServiceImpl extends ServiceImpl<PermissionRequestMapper, PermissionRequest> implements PermissionRequestService {

    private final SysRoleService sysRoleService;

    private final SysUserService sysUserService;

    private final SysUserRoleService sysUserRoleService;

    @Override
    public IPage<PermissionRequest> queryPage(QueryPageParam queryPageParam) {
        //创建Page对象
        IPage<PermissionRequest> page = new Page<>(queryPageParam.getCurrent(), queryPageParam.getSize());

        //构建条件
        LambdaQueryWrapper<PermissionRequest> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(PermissionRequest::getUpdateTime);
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
    public void dealRequest(PermissionRequest request) {
        //更新请求
        this.updateById(request);
        Long userId = request.getUserId();
        //如果通过
        if (RequestStatus.APPROVED.getCode() == request.getStatus()) {
            //更新用户信息状态为正常
            sysUserService.update(new LambdaUpdateWrapper<SysUser>()
                    .eq(SysUser::getUserId, userId)
                    .set(SysUser::getStatus, UserStatus.NORMAL.getCode()));
            //获取申请的角色名
            String roleName = request.getRoleName();
            //查询角色
            SysRole role = sysRoleService.getOne(new LambdaQueryWrapper<SysRole>()
                    .eq(SysRole::getRoleName, roleName));
            if(role != null){
                Long roleId = role.getRoleId();
                //删除原来的角色
                sysUserRoleService.remove(new LambdaUpdateWrapper<SysUserRole>()
                        .eq(SysUserRole::getRoleId,roleId)
                        .eq(SysUserRole::getUserId,userId));
                //创建新的用户角色
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRoleService.save(sysUserRole);
            }
        }
    }
}

