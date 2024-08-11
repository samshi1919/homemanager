package com.zuoer.controller.admin;



import com.zuoer.common.AppErrorCode;
import com.zuoer.common.Log;
import com.zuoer.common.base.QueryPageParam;
import com.zuoer.common.base.ResponseData;
import com.zuoer.common.base.ResponsePage;
import com.zuoer.domain.entity.FitmentCategoryItem;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.service.FitmentCategoryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "装修类型项目表相关API")
@RestController
@RequestMapping("/fitmentCategoryItem")
@RequiredArgsConstructor
public class FitmentCategoryItemController{

    private final FitmentCategoryItemService fitmentCategoryItemService;

    @ApiOperation(value = "新增数据")
    @PostMapping("/save")
    public ResponseData save(@Validated @RequestBody FitmentCategoryItem fitmentCategoryItem) {
        fitmentCategoryItemService.save(fitmentCategoryItem);
        return ResponseData.success();
    }
    
    @ApiOperation("修改数据")
    @PutMapping(value = "/update")
    public ResponseData update(@Validated @RequestBody FitmentCategoryItem fitmentCategoryItem) {
        fitmentCategoryItemService.updateById(fitmentCategoryItem);
        return ResponseData.success();
    }

    @ApiOperation("删除数据")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseData delete(@PathVariable Long id) {
        fitmentCategoryItemService.removeById(id);
        return ResponseData.success();
    }
    
    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResponseData queryPage(@RequestBody @Validated QueryPageParam queryPageParam) {
        IPage<FitmentCategoryItem> page = fitmentCategoryItemService.queryPage(queryPageParam);
        return ResponseData.success(ResponsePage.build(page.getTotal(), page.getRecords()));
    }

    @ApiOperation("查询所有")
    @GetMapping(value = "/queryAll")
    public ResponseData queryAll() {
        List<FitmentCategoryItem> list = fitmentCategoryItemService.list();
        return ResponseData.success(list);
    }
}

