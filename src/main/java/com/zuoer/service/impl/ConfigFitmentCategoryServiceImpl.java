package com.zuoer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.mapper.ConfigFitmentCategoryMapper;
import com.zuoer.domain.entity.ConfigFitmentCategory;
import com.zuoer.service.ConfigFitmentCategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Map;

/**
 * 装修阶段类型配置表(ConfigFitmentCategory)表服务实现类
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@Service("configFitmentCategoryService")
@RequiredArgsConstructor
public class ConfigFitmentCategoryServiceImpl extends ServiceImpl<ConfigFitmentCategoryMapper, ConfigFitmentCategory> implements ConfigFitmentCategoryService {
    
    @Override
    public IPage<ConfigFitmentCategory> queryPage(QueryPageParam queryPageParam) {
        //创建Page对象
        IPage<ConfigFitmentCategory> page = new Page<>(queryPageParam.getCurrent(), queryPageParam.getSize());

        //构建条件
        LambdaQueryWrapper<ConfigFitmentCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(ConfigFitmentCategory::getUpdateTime);
        Map<String, Object> map = (Map<String, Object>) queryPageParam.getParam();
        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (null != map) {
          //构造筛选条件
        }
        return this.baseMapper.selectPage(page, wrapper);
    }
}

