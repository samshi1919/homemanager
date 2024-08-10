package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.ConfigHouse;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.ConfigHouseVO;
import java.util.List;

/**
 * 房屋配置表(ConfigHouse)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
public interface ConfigHouseService extends IService<ConfigHouse> {

    /**
     * ConfigHouse 分页列表
     *
     * @return
     */   
    IPage<ConfigHouse> queryPage(QueryPageParam queryPageParam);

}

