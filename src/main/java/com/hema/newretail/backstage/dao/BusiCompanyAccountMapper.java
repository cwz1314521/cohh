package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BusiCompanyAccountEntry;

public interface BusiCompanyAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BusiCompanyAccountEntry record);

    int insertSelective(BusiCompanyAccountEntry record);

    BusiCompanyAccountEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusiCompanyAccountEntry record);

    int updateByRefIdSelective(BusiCompanyAccountEntry record);

    int updateByPrimaryKey(BusiCompanyAccountEntry record);
}