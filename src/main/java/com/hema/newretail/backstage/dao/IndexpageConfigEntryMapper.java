package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.IndexpageConfigEntry;
import com.hema.newretail.backstage.model.index.IndexConfigBo;

import java.util.List;

public interface IndexpageConfigEntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexpageConfigEntry record);

    int insertSelective(IndexpageConfigEntry record);

    IndexpageConfigEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexpageConfigEntry record);

    int updateByPrimaryKey(IndexpageConfigEntry record);

    /**
     *
     * @return
     */
    List<IndexConfigBo> selectIndexConfig();

    int deleteAll();

    /**
     *
     * @param datList
     * @return
     */
    int insertBatch(List<IndexpageConfigEntry> datList);

}