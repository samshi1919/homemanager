package com.zuoer.controller.mini;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zuoer.common.base.ResponseData;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.dto.WechatUserUpdate;
import com.zuoer.domain.entity.PermissionRequest;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.SysUserVO;
import com.zuoer.enums.RequestStatus;
import com.zuoer.service.PermissionRequestService;
import com.zuoer.service.SysRoleService;
import com.zuoer.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "小程序用户接口")
@RestController
@RequestMapping("/mini/user")
@RequiredArgsConstructor
public class WechatUserController {

    private final SysUserService sysUserService;

    private final PermissionRequestService permissionRequestService;

    private final SysRoleService sysRoleService;

    @ApiOperation("登录/注册")
    @PostMapping("/login")
    public ResponseData login(@RequestBody @Validated SysUserLoginDTO sysUser) {
        // 手动创建 Shiro 的登录 token
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getPhoneNumber(), "");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        // 获取认证后的用户信息并返回
        SysUserVO user = (SysUserVO) subject.getPrincipal();
        return ResponseData.success(user);
    }


    @ApiOperation("查询用户列表")
    @GetMapping("/getUserList")
    public ResponseData getUserList(SysUserQuery query) {
        return ResponseData.success(sysUserService.getUserList(query));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo/{phoneNumber}")
    public ResponseData getUserInfo(@PathVariable String phoneNumber) {
        return ResponseData.success(sysUserService.getUserInfo(phoneNumber));
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/updateUserInfo")
    public ResponseData updateUserInfo(@RequestBody WechatUserUpdate userUpdate) {
        sysUserService.updateWechatUserInfo(userUpdate);
        return ResponseData.success();
    }

    @ApiOperation("获取申中请列表")
    @GetMapping("/requestList")
    public ResponseData queryRequestList() {
        List<PermissionRequest> requestList = permissionRequestService.list(new LambdaQueryWrapper<PermissionRequest>()
                .eq(PermissionRequest::getStatus, RequestStatus.PROGRESS.getCode()));
        return ResponseData.success(requestList);
    }

    @ApiOperation("处理申请")
    @PostMapping("/dealRequest")
    public ResponseData dealRequest(@RequestBody @Validated PermissionRequest permissionRequest) {
        permissionRequestService.dealRequest(permissionRequest);
        return ResponseData.success();
    }

    @ApiOperation("查询所有角色")
    @GetMapping("/getRoleList")
    public ResponseData getRoleList() {
        return ResponseData.success(sysRoleService.list());
    }


}
