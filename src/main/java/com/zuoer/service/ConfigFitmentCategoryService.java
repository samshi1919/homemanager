package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.ConfigFitmentCategory;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.ConfigFitmentCategoryVO;
import java.util.List;

/**
 * 装修阶段类型配置表(ConfigFitmentCategory)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
public interface ConfigFitmentCategoryService extends IService<ConfigFitmentCategory> {

    /**
     * ConfigFitmentCategory 分页列表
     *
     * @return
     */   
    IPage<ConfigFitmentCategory> queryPage(QueryPageParam queryPageParam);

}

