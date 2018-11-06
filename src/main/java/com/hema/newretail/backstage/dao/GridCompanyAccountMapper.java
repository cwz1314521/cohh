package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridCompanyAccountEntry;

public interface GridCompanyAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridCompanyAccountEntry record);

    int insertSelective(GridCompanyAccountEntry record);

    GridCompanyAccountEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridCompanyAccountEntry record);

    int updateByPrimaryKey(GridCompanyAccountEntry record);
}