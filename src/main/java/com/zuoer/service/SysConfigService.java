package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.SysConfig;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.SysConfigVO;
import java.util.List;

/**
 * (SysConfig)表服务接口
 *
 * @author xm
 * @since 2024-08-11 21:13:34
 */
public interface SysConfigService extends IService<SysConfig> {

    /**
     * SysConfig 分页列表
     *
     * @return
     */   
    IPage<SysConfig> queryPage(QueryPageParam queryPageParam);

}

