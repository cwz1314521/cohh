package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.gridKpiEntry;

public interface gridKpiMapper {
    int deleteByPrimaryKey(Long id);

    int insert(gridKpiEntry record);

    int insertSelective(gridKpiEntry record);

    gridKpiEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(gridKpiEntry record);

    int updateByPrimaryKey(gridKpiEntry record);
}