package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.RefZoneMachine;

import java.util.List;
import java.util.Map;

public interface RefZoneMachineMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RefZoneMachine record);

    int insertSelective(RefZoneMachine record);

    RefZoneMachine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RefZoneMachine record);

    int updateByPrimaryKey(RefZoneMachine record);

    /**
     * @param list
     * @return
     */
    int insertBatch(List<RefZoneMachine> list);

    /**
     * 根据zoneid查询所有hashcode
     *
     * @param zoneId
     * @return
     */
    List<RefZoneMachine> selectByZoneid(Long zoneId);

    /**
     * 删除指定片区的所有网格
     *
     * @param zoneId
     * @return
     */
    int deleteByZoneid(Long zoneId);

    /**
     * 一键查询所有网格
     *
     * @param paramsMap
     * @return
     */
    List<RefZoneMachine> selectAllGruidByArea(Map<String, Object> paramsMap);
}