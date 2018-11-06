package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseGlobalInfoEntry;

public interface BaseGlobalInfoMapper {


    BaseGlobalInfoEntry selectByKey(String key);

    int deleteByPrimaryKey(Long id);

    int insert(BaseGlobalInfoEntry record);

    int insertSelective(BaseGlobalInfoEntry record);

    BaseGlobalInfoEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseGlobalInfoEntry record);

    int updateByPrimaryKey(BaseGlobalInfoEntry record);
}