package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.erp.OrderListDBCondition;
import com.hema.newretail.backstage.entry.erp.ErpIngredientOrderEntry;
import com.hema.newretail.backstage.model.erp.OrderListBo;

import java.util.List;

public interface ErpIngredientOrderMapper {




    List<OrderListBo> selectByCondition(OrderListDBCondition orderListDBCondition);

    int selectAllCount();

    int deleteByPrimaryKey(Long id);

    int insert(ErpIngredientOrderEntry record);

    int insertSelective(ErpIngredientOrderEntry record);

    ErpIngredientOrderEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpIngredientOrderEntry record);

    int updateByPrimaryKey(ErpIngredientOrderEntry record);
}