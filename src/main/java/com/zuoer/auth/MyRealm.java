package com.zuoer.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.SysUserVO;
import com.zuoer.enums.UserStatus;
import com.zuoer.mapper.SysUserMapper;
import com.zuoer.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyRealm extends AuthorizingRealm {


    private final SysUserService userService;

    private final SysUserMapper sysUserMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phoneNumber = (String) token.getPrincipal();

        // 根据手机号查询用户
        SysUser sysUser = userService.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getPhoneNumber, phoneNumber));
        if (sysUser == null || UserStatus.DISABLED.getCode() == sysUser.getStatus()) {
            throw new UnknownAccountException("手机号不存在或已被禁用");
        } else {
            //正常状态，查询相关信息返回
            SysUserQuery query = new SysUserQuery();
            query.setUserId(sysUser.getUserId());
            SysUserVO sysUserVO = sysUserMapper.getUserInfo(query);
            // 返回用户信息作为认证信息
            return new SimpleAuthenticationInfo(sysUserVO, "", getName());
        }

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        SysUserVO sysUserVO = (SysUserVO) principals.getPrimaryPrincipal();
        //2.添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> roleNames = sysUserVO.getRoleNames();
        for (String roleName : roleNames) {
            simpleAuthorizationInfo.addRole(roleName);

        }
        return simpleAuthorizationInfo;
    }
}
