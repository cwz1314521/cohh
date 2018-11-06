package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.grid.GridListTaskCondition;
import com.hema.newretail.backstage.entry.grid.GridTasksEntry;
import com.hema.newretail.backstage.model.grid.GridTaskBo;

import java.util.List;

public interface GridTasksMapper {


    /**
     * 任务条件查询
     */
    List<GridTaskBo> selectTaskByCondition(GridListTaskCondition gridListTaskCondition);

    GridTaskBo selectEditById(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(GridTasksEntry record);

    int insertSelective(GridTasksEntry record);

    GridTasksEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridTasksEntry record);

    int updateByPrimaryKeyWithBLOBs(GridTasksEntry record);

    int updateByPrimaryKey(GridTasksEntry record);
}