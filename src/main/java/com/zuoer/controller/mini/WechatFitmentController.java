package com.zuoer.controller.mini;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zuoer.common.base.ResponseData;
import com.zuoer.domain.entity.FitmentCategoryItem;
import com.zuoer.service.ConfigFitmentCategoryService;
import com.zuoer.service.FitmentCategoryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "小程序装修菜单接口")
@RestController
@RequestMapping("/mini/fitment")
@RequiredArgsConstructor
public class WechatFitmentController {

    private final ConfigFitmentCategoryService configFitmentCategoryService;

    private final FitmentCategoryItemService fitmentCategoryItemService;

    @ApiOperation("查询所有分类")
    @GetMapping("/listAllCategory")
    public ResponseData listAllCategory() {
        return ResponseData.success(configFitmentCategoryService.list());
    }

    @ApiOperation("根据分类id查询子项")
    @GetMapping("/listItemsByCategory/{categoryId}")
    public ResponseData listItemsByCategory(@PathVariable Long categoryId) {
        List<FitmentCategoryItem> itemList = fitmentCategoryItemService.list(new LambdaQueryWrapper<FitmentCategoryItem>()
                .eq(FitmentCategoryItem::getCategoryId, categoryId)
                .orderByDesc(FitmentCategoryItem::getCreateDate));
        return ResponseData.success(itemList);
    }

}
