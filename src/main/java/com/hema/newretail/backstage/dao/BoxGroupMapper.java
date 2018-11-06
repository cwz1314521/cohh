package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BoxGroup;
import com.hema.newretail.backstage.model.zonebase.BoxGroupBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BoxGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BoxGroup record);

    int insertSelective(BoxGroup record);

    BoxGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BoxGroup record);

    int updateByPrimaryKey(BoxGroup record);

    /**
     * @param paramsMap
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<BoxGroupBo> selectBoxGroup(@Param("paramsMap") Map<String, Object> paramsMap, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}