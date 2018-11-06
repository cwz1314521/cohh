package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseFunction;

public interface BaseFunctionMapper {
    int deleteByPrimaryKey(String funcCode);

    int insert(BaseFunction record);

    int insertSelective(BaseFunction record);

    BaseFunction selectByPrimaryKey(String funcCode);

    int updateByPrimaryKeySelective(BaseFunction record);

    int updateByPrimaryKey(BaseFunction record);
}