package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseMachineInfoEntry;

public interface BaseMachineInfoMapper {

    BaseMachineInfoEntry selectByUId(String machineUuid);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMachineInfoEntry record);

    int insertSelective(BaseMachineInfoEntry record);

    BaseMachineInfoEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseMachineInfoEntry record);

    int updateByPrimaryKeyWithBLOBs(BaseMachineInfoEntry record);

    int updateByPrimaryKey(BaseMachineInfoEntry record);
}