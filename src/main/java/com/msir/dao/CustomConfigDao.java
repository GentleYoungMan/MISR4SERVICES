package com.msir.dao;

import com.msir.entity.CustomConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/6.
 * 系统的后端的配置接口
 */
public interface CustomConfigDao extends SuperBasicDao<CustomConfig>{

    List<CustomConfig> queryDao();

    int insertDao(CustomConfig customConfigDao);

    int deleteDao(@Param("cusId") int cusId);//t=ID

    int updateDao(CustomConfig customConfigDao);
}
