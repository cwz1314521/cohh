package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.erp.ManufacturerListCondition;
import com.hema.newretail.backstage.common.queryparam.erp.ListManufacturerCondition;
import com.hema.newretail.backstage.entry.erp.ErpIngredientManufacturerEntry;
import com.hema.newretail.backstage.model.erp.ListManufacturerBo;
import com.hema.newretail.backstage.model.erp.ManufacturerListBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpIngredientManufacturerMapper {



    int selectCountByUserNameEdit(@Param("userName") String userName, @Param("id") Long id);

    int selectCountByUserName(@Param("userName") String userName);


    List<ListManufacturerBo> selectBySelect(ListManufacturerCondition listManufacturerCondition);

    int selectAllCount();

    List<ManufacturerListBo> selectByCondition(ManufacturerListCondition manufacturerListCondition);

    int deleteByPrimaryKey(Long id);

    int insert(ErpIngredientManufacturerEntry record);

    int insertSelective(ErpIngredientManufacturerEntry record);

    ErpIngredientManufacturerEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpIngredientManufacturerEntry record);

    int updateByPrimaryKey(ErpIngredientManufacturerEntry record);
}