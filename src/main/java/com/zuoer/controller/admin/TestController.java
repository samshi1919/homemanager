package com.zuoer.controller.admin;

import com.zuoer.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api("test controller")
public class TestController {

    @ApiOperation("测试")
    @GetMapping("/test")
    public Result test() {
        return new Result();
    }
}
