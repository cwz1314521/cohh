package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.IndexpageDetailEntry;

import java.util.List;

public interface IndexpageDetailEntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexpageDetailEntry record);

    int insertSelective(IndexpageDetailEntry record);

    IndexpageDetailEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexpageDetailEntry record);

    int updateByPrimaryKey(IndexpageDetailEntry record);

    /**
     *
     * @return
     */
    int deleteAll();

    /**
     *
     * @param dataList
     * @return
     */
    int insertBatch(List<IndexpageDetailEntry> dataList);
}