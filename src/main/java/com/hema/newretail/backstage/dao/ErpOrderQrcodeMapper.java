package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.erp.InStoreDBCondition;
import com.hema.newretail.backstage.common.queryparam.erp.InStoreRecordListDBCondition;
import com.hema.newretail.backstage.entry.erp.ErpOrderQrcodeEntry;
import com.hema.newretail.backstage.model.erp.InStoreListBo;
import com.hema.newretail.backstage.model.erp.InStoreTodayBo;
import com.hema.newretail.backstage.model.erp.InstoreRecordBo;

import java.util.List;

public interface ErpOrderQrcodeMapper {


    List<InstoreRecordBo> selectRecordMap(InStoreRecordListDBCondition inStoreRecordListDBCondition);

    List<InStoreTodayBo> selectInStoreTodayMap();

    List<InStoreListBo> selectBaseInStoreListMap();

    int updateByQrcodeCode(String qrcodeCode);

    int deleteByPrimaryKey(Long id);

    int insert(ErpOrderQrcodeEntry record);

    int insertSelective(ErpOrderQrcodeEntry record);

    ErpOrderQrcodeEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpOrderQrcodeEntry record);

    int updateByInStoreDBCondition(InStoreDBCondition inStoreDBCondition);

    int updateByPrimaryKey(ErpOrderQrcodeEntry record);
}