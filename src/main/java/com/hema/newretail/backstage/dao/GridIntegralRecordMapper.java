package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridIntegralRecordEntry;

import java.util.List;

public interface GridIntegralRecordMapper {

    /**根据GridCompanyId检索数据*/
    List<GridIntegralRecordEntry> selectByGridCompanyId(Long companyId);

    int deleteByPrimaryKey(Long id);

    int insert(GridIntegralRecordEntry record);

    int insertSelective(GridIntegralRecordEntry record);

    GridIntegralRecordEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridIntegralRecordEntry record);

    int updateByPrimaryKey(GridIntegralRecordEntry record);
}