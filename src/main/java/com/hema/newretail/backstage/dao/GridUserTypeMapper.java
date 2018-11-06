package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridUserTypeEntry;

public interface GridUserTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridUserTypeEntry record);

    int insertSelective(GridUserTypeEntry record);

    GridUserTypeEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridUserTypeEntry record);

    int updateByPrimaryKey(GridUserTypeEntry record);
}