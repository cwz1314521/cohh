package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridKpiModeEntry;

import java.util.List;

public interface GridKpiModeMapper {


    List<GridKpiModeEntry> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(GridKpiModeEntry record);

    int insertSelective(GridKpiModeEntry record);

    GridKpiModeEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridKpiModeEntry record);

    int updateByPrimaryKey(GridKpiModeEntry record);
}