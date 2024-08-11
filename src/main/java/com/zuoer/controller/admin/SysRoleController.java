package com.zuoer.controller.admin;



import com.zuoer.common.AppErrorCode;
import com.zuoer.common.Log;
import com.zuoer.common.base.QueryPageParam;
import com.zuoer.common.base.ResponseData;
import com.zuoer.common.base.ResponsePage;
import com.zuoer.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "角色表相关API")
@RestController
@RequestMapping("/sysRole")
@RequiredArgsConstructor
public class SysRoleController{

    private final SysRoleService sysRoleService;

    @ApiOperation(value = "新增数据")
    @PostMapping("/save")
    public ResponseData save(@Validated @RequestBody SysRole sysRole) {
        sysRoleService.save(sysRole);
        return ResponseData.success();
    }
    
    @ApiOperation("修改数据")
    @PutMapping(value = "/update")
    public ResponseData update(@Validated @RequestBody SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return ResponseData.success();
    }

    @ApiOperation("删除数据")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseData delete(@PathVariable Long id) {
        sysRoleService.removeById(id);
        return ResponseData.success();
    }
    
    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResponseData queryPage(@RequestBody @Validated QueryPageParam queryPageParam) {
        IPage<SysRole> page = sysRoleService.queryPage(queryPageParam);
        return ResponseData.success(ResponsePage.build(page.getTotal(), page.getRecords()));
    }

    @ApiOperation("查询所有")
    @GetMapping(value = "/queryAll")
    public ResponseData queryAll() {
        List<SysRole> list = sysRoleService.list();
        return ResponseData.success(list);
    }
}

