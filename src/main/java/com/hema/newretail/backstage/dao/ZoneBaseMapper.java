package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseMachineInfoEntry;
import com.hema.newretail.backstage.entry.ZoneBase;
import com.hema.newretail.backstage.model.zonebase.ZoneBo;
import com.hema.newretail.backstage.model.zonebase.ZoneMapGridBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ZoneBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZoneBase record);

    int insertSelective(ZoneBase record);

    ZoneBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZoneBase record);

    int updateByPrimaryKey(ZoneBase record);

    /**
     * @param paramsMap
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ZoneBo> selectZoneListByCondition(@Param("paramsMap") Map<String, Object> paramsMap, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查看片区地图网格
     *
     * @param paramsMap
     * @return
     */
    List<ZoneMapGridBo> selectZoneForMap(@Param("paramsMap") Map<String, Object> paramsMap);

    /**
     * @param hashcodes
     * @return
     */
    Integer selectMachineNumByHashcode(@Param("hashcodes") String[] hashcodes);

    List<String> getHashCode(List<Long> list);

    List<String> getMachHashCode(Map<String, Object> paramsMap);

    /**
     * 查询交叉网格
     *
     * @param hashcodes
     * @return
     */
    List<String> getHashCodeCross(@Param("hashcodes") String[] hashcodes, @Param("zoneId") Long zoneId);
}