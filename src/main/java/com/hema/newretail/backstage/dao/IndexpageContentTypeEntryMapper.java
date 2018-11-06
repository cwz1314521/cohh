package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.IndexpageContentTypeEntry;

import java.util.List;

public interface IndexpageContentTypeEntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexpageContentTypeEntry record);

    int insertSelective(IndexpageContentTypeEntry record);

    IndexpageContentTypeEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexpageContentTypeEntry record);

    int updateByPrimaryKey(IndexpageContentTypeEntry record);

    /**
     *
     * @return
     */
    List<IndexpageContentTypeEntry> selectAllData();
}