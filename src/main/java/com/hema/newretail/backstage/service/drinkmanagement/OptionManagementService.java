package com.hema.newretail.backstage.service.drinkmanagement;

import com.github.pagehelper.PageInfo;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.entry.BasePropertiesTypeEntry;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by jiahao on 2018-08-23
 */
public interface OptionManagementService {

    String insertAndUpdateOption(Long id, String typeName, Long ingredientId, String proName, boolean status);

    List<BaseIngredientInfoEntry> selectIngredientInfo();

    PageInfo<BasePropertiesTypeEntry> selectOptionList(Integer pageNum, Integer pageSize);
}
