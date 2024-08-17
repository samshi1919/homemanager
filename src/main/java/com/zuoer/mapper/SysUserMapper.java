package com.zuoer.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.zuoer.domain.entity.SysUser;
import com.zuoer.domain.query.SysUserQuery;
import com.zuoer.domain.vo.SysUserVO;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * (SysUser)表数据库访问层
 *
 * @author xm
 * @since 2024-08-10 11:23:32
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取SysUser列表
     *
     * @param queryParams 查询参数
     * @return
     */
    List<SysUserVO> listSysUser(@Param("queryParams") SysUserQuery queryParams);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUser> entities);

    SysUserVO getUserInfo(@Param("query") SysUserQuery sysUserQuery);


    List<SysUserVO> listUserInfo(@Param("query") SysUserQuery sysUserQuery);

}

