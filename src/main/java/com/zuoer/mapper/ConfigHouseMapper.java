package com.zuoer.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.zuoer.domain.entity.ConfigHouse;
import com.zuoer.domain.query.ConfigHouseQuery;
import com.zuoer.domain.vo.ConfigHouseVO;

/**
 * 房屋配置表(ConfigHouse)表数据库访问层
 *
 * @author xm
 * @since 2024-08-10 17:46:22
 */
@Mapper
public interface ConfigHouseMapper extends BaseMapper<ConfigHouse> {

    /**
     * 获取ConfigHouse列表
     *
     * @param queryParams 查询参数
     * @return
     */
    List<ConfigHouseVO> listConfigHouse(@Param("queryParams") ConfigHouseQuery queryParams);

    /**
    * 批量新增数据（MyBatis原生foreach方法）
    *
    * @param entities List<ConfigHouse> 实例对象列表
    * @return 影响行数
    */
    int insertBatch(@Param("entities") List<ConfigHouse> entities);

    /**
    * 批量新增或按主键更新数据（MyBatis原生foreach方法）
    *
    * @param entities List<ConfigHouse> 实例对象列表
    * @return 影响行数
    * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
    */
    int insertOrUpdateBatch(@Param("entities") List<ConfigHouse> entities);

}

