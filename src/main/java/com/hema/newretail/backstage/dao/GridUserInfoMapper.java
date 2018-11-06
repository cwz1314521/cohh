package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridUserInfoEntry;

public interface GridUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GridUserInfoEntry record);

    int insertSelective(GridUserInfoEntry record);

    GridUserInfoEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridUserInfoEntry record);

    int updateByPrimaryKey(GridUserInfoEntry record);
}