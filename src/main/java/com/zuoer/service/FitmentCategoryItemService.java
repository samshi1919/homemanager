package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.FitmentCategoryItem;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.FitmentCategoryItemVO;
import java.util.List;

/**
 * 装修类型项目表(FitmentCategoryItem)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
public interface FitmentCategoryItemService extends IService<FitmentCategoryItem> {

    /**
     * FitmentCategoryItem 分页列表
     *
     * @return
     */   
    IPage<FitmentCategoryItem> queryPage(QueryPageParam queryPageParam);

}

