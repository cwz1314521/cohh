package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridUserTaskEntry;

public interface GridUserTaskMapper {
    int deleteByPrimaryKey(Long taskId);

    int insert(GridUserTaskEntry record);

    int insertSelective(GridUserTaskEntry record);

    GridUserTaskEntry selectByPrimaryKey(Long taskId);

    int updateByPrimaryKeySelective(GridUserTaskEntry record);

    int updateByPrimaryKey(GridUserTaskEntry record);
}