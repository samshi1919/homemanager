package com.zuoer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuoer.domain.entity.ItemAttachment;
import com.zuoer.common.base.QueryPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoer.domain.vo.ItemAttachmentVO;
import java.util.List;

/**
 * 装修项目文件表(ItemAttachment)表服务接口
 *
 * @author xm
 * @since 2024-08-10 17:46:21
 */
public interface ItemAttachmentService extends IService<ItemAttachment> {

    /**
     * ItemAttachment 分页列表
     *
     * @return
     */   
    IPage<ItemAttachment> queryPage(QueryPageParam queryPageParam);

}

