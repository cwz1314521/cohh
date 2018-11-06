package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.erp.ErpContractPicEntry;

import java.util.List;

public interface ErpContractPicMapper {

    int inserts(List<ErpContractPicEntry> list);

    int deleteByPrimaryKey(Long id);

    int deleteByMId(Long id);

    int insert(ErpContractPicEntry record);

    int insertSelective(ErpContractPicEntry record);

    ErpContractPicEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpContractPicEntry record);

    int updateByPrimaryKey(ErpContractPicEntry record);
}