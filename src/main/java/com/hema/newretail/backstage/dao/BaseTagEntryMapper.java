package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.tag.TagCountTagNameCondition;
import com.hema.newretail.backstage.entry.BaseTagEntry;

import java.util.List;

public interface BaseTagEntryMapper {


    int selectCountByTNameNotThisId(TagCountTagNameCondition tagCountTagNameCondition);

    int selectCountByTName(String tagname);

    List<BaseTagEntry> selectNotDelete();

    int deleteByPrimaryKey(Long id);

    int insert(BaseTagEntry record);

    int insertSelective(BaseTagEntry record);

    BaseTagEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseTagEntry record);

    int updateByPrimaryKey(BaseTagEntry record);
}