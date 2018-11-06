package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridIntegralRuleEntry;

import java.util.List;

public interface GridIntegralRuleMapper {

    /**检索公司下边有几条记录*/
    List<GridIntegralRuleEntry> selectByCompany(Long gridCompanyId);

    int deleteByPrimaryKey(Long id);

    int insert(GridIntegralRuleEntry record);

    int insertSelective(GridIntegralRuleEntry record);

    GridIntegralRuleEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridIntegralRuleEntry record);

    int updateByPrimaryKey(GridIntegralRuleEntry record);
}