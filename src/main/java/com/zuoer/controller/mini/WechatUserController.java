package com.zuoer.controller.mini;

import com.zuoer.common.base.ResponseData;
import com.zuoer.domain.dto.SysUserLoginDTO;
import com.zuoer.domain.vo.SysUserVO;
import com.zuoer.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "小程序用户接口")
@RestController
@RequestMapping("/mini/user")
@RequiredArgsConstructor
public class WechatUserController {

    private final SysUserService sysUserService;

    @ApiOperation("登录/注册")
    @PostMapping(value = "/login")
    public ResponseData queryAll(@RequestBody @Validated SysUserLoginDTO sysUser) {
        SysUserVO userVO = sysUserService.login(sysUser);
        return ResponseData.success(userVO);
    }
}
