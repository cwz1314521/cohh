package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.IndexpageCssEntry;

import java.util.List;

public interface IndexpageCssEntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexpageCssEntry record);

    int insertSelective(IndexpageCssEntry record);

    IndexpageCssEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexpageCssEntry record);

    int updateByPrimaryKey(IndexpageCssEntry record);

    /**
     * 查询所有标签
     *
     * @return
     */
    List<IndexpageCssEntry> selectAllData();
}