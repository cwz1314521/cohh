package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;

import java.util.Map;

/**
 * 配料字典接口
 */
public interface IBaseIngredientInfoDataService {
    public boolean save(BaseIngredientInfoEntry data);
    public BaseIngredientInfoEntry findOneById(long id);
    public Response findAll(Map<String,Object> params);
    public String deleteById(long id);
}
