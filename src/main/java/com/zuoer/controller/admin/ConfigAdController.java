package com.zuoer.controller.admin;



import com.zuoer.common.AppErrorCode;
import com.zuoer.common.Log;
import com.zuoer.common.base.QueryPageParam;
import com.zuoer.common.base.ResponseData;
import com.zuoer.common.base.ResponsePage;
import com.zuoer.domain.entity.ConfigAd;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.service.ConfigAdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "广告配置表相关API")
@RestController
@RequestMapping("/admin/configAd")
@RequiredArgsConstructor
public class ConfigAdController{

    private final ConfigAdService configAdService;

    @ApiOperation(value = "新增数据")
    @PostMapping("/save")
    public ResponseData save(@Validated @RequestBody ConfigAd configAd) {
        configAdService.save(configAd);
        return ResponseData.success();
    }
    
    @ApiOperation("修改数据")
    @PutMapping(value = "/update")
    public ResponseData update(@Validated @RequestBody ConfigAd configAd) {
        configAdService.updateById(configAd);
        return ResponseData.success();
    }

    @ApiOperation("删除数据")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseData delete(@PathVariable Long id) {
        configAdService.removeById(id);
        return ResponseData.success();
    }
    
    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResponseData queryPage(@RequestBody @Validated QueryPageParam queryPageParam) {
        IPage<ConfigAd> page = configAdService.queryPage(queryPageParam);
        return ResponseData.success(ResponsePage.build(page.getTotal(), page.getRecords()));
    }


    @ApiOperation("查询所有")
    @GetMapping(value = "/queryAll")
    public ResponseData queryAll() {
        List<ConfigAd> list = configAdService.list();
        return ResponseData.success(list);
    }
}

