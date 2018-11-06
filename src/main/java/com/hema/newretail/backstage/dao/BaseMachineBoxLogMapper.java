package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseMachineBoxLogEntry;
import com.hema.newretail.backstage.model.grid.BoxLogBo;

import java.util.List;

public interface BaseMachineBoxLogMapper {


    List<BoxLogBo> selectByCreate(Long version);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMachineBoxLogEntry record);

    int insertSelective(BaseMachineBoxLogEntry record);

    BaseMachineBoxLogEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseMachineBoxLogEntry record);

    int updateByPrimaryKey(BaseMachineBoxLogEntry record);
}