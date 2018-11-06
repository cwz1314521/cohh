package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.BoxGroupIngredientCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.IngredientCondition;

/**
 * @Auther: 程文政
 * @Date: 2018/8/24 18:02
 * @Description:配料类型接口
 * @Version: 1.0
 */
public interface IBatchingTypeManagementService {

    //查询配料组合列表接口
    public Response mixList(IngredientCondition ingredientCondition);

    //删除配料组合列表接口
    public Response mixDelete(Long id);

    //查询所有配料信息接口
    public Response ingredientInfo(Long boxGroupId);

    //添加/修改料盒分配接口
    public Response binAllocationEditAdd(BoxGroupIngredientCondition boxGroupIngredientCondition);

    //查询料盒分配接口
    public Response binAllocationList();

    /**查询所有配料*/
    public Response allIngredients();
}
