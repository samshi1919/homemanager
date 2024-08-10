package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.HouseUser;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.HouseUserVO;
import java.util.List;

/**
 * 房屋用户关系表(HouseUser)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
public interface HouseUserService extends IService<HouseUser> {

    /**
     * HouseUser 分页列表
     *
     * @return
     */   
    IPage<HouseUser> queryPage(QueryPageParam queryPageParam);

}

