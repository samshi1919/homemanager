package com.zuoer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.mapper.FitmentCategoryItemMapper;
import com.zuoer.domain.entity.FitmentCategoryItem;
import com.zuoer.service.FitmentCategoryItemService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Map;

/**
 * 装修类型项目表(FitmentCategoryItem)表服务实现类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@Service("fitmentCategoryItemService")
@RequiredArgsConstructor
public class FitmentCategoryItemServiceImpl extends ServiceImpl<FitmentCategoryItemMapper, FitmentCategoryItem> implements FitmentCategoryItemService {
    
    @Override
    public IPage<FitmentCategoryItem> queryPage(QueryPageParam queryPageParam) {
        //创建Page对象
        IPage<FitmentCategoryItem> page = new Page<>(queryPageParam.getCurrent(), queryPageParam.getSize());

        //构建条件
        LambdaQueryWrapper<FitmentCategoryItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(FitmentCategoryItem::getUpdateTime);
        Map<String, Object> map = (Map<String, Object>) queryPageParam.getParam();
        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (null != map) {
          //构造筛选条件
        }
        return this.baseMapper.selectPage(page, wrapper);
    }
}

