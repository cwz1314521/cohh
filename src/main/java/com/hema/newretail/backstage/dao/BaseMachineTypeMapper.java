package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseMachineTypeEntry;

import java.util.List;

public interface BaseMachineTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseMachineTypeEntry record);

    int insertSelective(BaseMachineTypeEntry record);

    BaseMachineTypeEntry selectByPrimaryKey(Long id);

    List<BaseMachineTypeEntry> selectAll();

    int updateByPrimaryKeySelective(BaseMachineTypeEntry record);

    int updateByPrimaryKey(BaseMachineTypeEntry record);
}