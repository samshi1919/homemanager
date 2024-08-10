package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.ConfigAd;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.ConfigAdVO;
import java.util.List;

/**
 * 广告配置表(ConfigAd)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:44:55
 */
public interface ConfigAdService extends IService<ConfigAd> {

    /**
     * ConfigAd 分页列表
     *
     * @return
     */   
    IPage<ConfigAd> queryPage(QueryPageParam queryPageParam);

}

