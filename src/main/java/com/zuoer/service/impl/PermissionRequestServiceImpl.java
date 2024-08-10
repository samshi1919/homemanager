package com.zuoer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuoer.mapper.PermissionRequestMapper;
import com.zuoer.domain.entity.PermissionRequest;
import com.zuoer.service.PermissionRequestService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Map;

/**
 * 账号权限申请表(PermissionRequest)表服务实现类
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
@Service("permissionRequestService")
@RequiredArgsConstructor
public class PermissionRequestServiceImpl extends ServiceImpl<PermissionRequestMapper, PermissionRequest> implements PermissionRequestService {
    
    @Override
    public IPage<PermissionRequest> queryPage(QueryPageParam queryPageParam) {
        //创建Page对象
        IPage<PermissionRequest> page = new Page<>(queryPageParam.getCurrent(), queryPageParam.getSize());

        //构建条件
        LambdaQueryWrapper<PermissionRequest> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(PermissionRequest::getUpdateTime);
        Map<String, Object> map = (Map<String, Object>) queryPageParam.getParam();
        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (null != map) {
          //构造筛选条件
        }
        return this.baseMapper.selectPage(page, wrapper);
    }
}

