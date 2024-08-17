package com.zuoer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.dto.WechatUserUpdate;
import com.zuoer.domain.entity.*;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.ConfigHouseVO;
import com.zuoer.domain.vo.SysUserVO;
import com.zuoer.enums.RequestStatus;
import com.zuoer.enums.UserStatus;
import com.zuoer.mapper.SysUserMapper;
import com.zuoer.service.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private final HouseUserService houseUserService;

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

    @Override
    public SysUserVO getUserInfo(String phoneNumber) {
        SysUserQuery query = new SysUserQuery();
        query.setPhoneNumber(phoneNumber);
        return this.baseMapper.getUserInfo(query);
    }

    @Override
    public List<SysUserVO> getUserList(SysUserQuery query) {
        return this.baseMapper.listUserInfo(query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWechatUserInfo(WechatUserUpdate userUpdate) {
        Long userId = userUpdate.getUserId();
        //查询改用户是否存在
        SysUser sysUser = this.getById(userId);
        if (sysUser != null) {
            //更新用户角色
            //删除原来的角色
            sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId, userId));
            //新增用户角色
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(userUpdate.getRoleId());
            sysUserRoleService.save(sysUserRole);
            //更新用户房屋信息
            //删除原来的用户房屋关系
            houseUserService.remove(new LambdaQueryWrapper<HouseUser>()
                    .eq(HouseUser::getUserId, userId));
            //新增用户房屋关系
            List<ConfigHouseVO> houseList = userUpdate.getHouseList();
            if (houseList != null && !houseList.isEmpty()) {
                List<HouseUser> houseUserList = houseList.stream()
                        .map(configHouseVO -> {
                            HouseUser houseUser = new HouseUser();
                            houseUser.setUserId(userId);
                            houseUser.setHouseId(configHouseVO.getHouseId());
                            houseUser.setHouseRole(configHouseVO.getHouseRole());
                            return houseUser;
                        })
                        .collect(Collectors.toList());
                houseUserService.saveBatch(houseUserList);
            }
        }


    }
}

