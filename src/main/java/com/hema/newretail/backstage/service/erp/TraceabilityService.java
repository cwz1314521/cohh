package com.hema.newretail.backstage.service.erp;

import com.hema.newretail.backstage.common.queryparam.erp.*;
import com.hema.newretail.backstage.common.utils.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * @Department 新零售
 * @ClassName TraceabilityService
 * @Description 溯源系统Service
 * @Author ---CWZ
 * @Date 2018/10/31 11:59
 * @Version 1.0
 **/
public interface TraceabilityService {


    /**
     * 功能描述:原料厂商---总后台列表展示
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response manufacturerList(ManufacturerListCondition manufacturerListCondition);

    /**
     *
     * 功能描述:原料厂商---添加
     *
     * @param: ManufacturerAddCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response manufacturerAdd(ManufacturerAddCondition manufacturerAddCondition);

    /**
     *
     * 功能描述:原料厂商---编辑
     *
     * @param: ManufacturerEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response manufacturerEdit(ManufacturerEditCondition manufacturerEditCondition);

    /**
     *
     * 功能描述:订单列表
     *
     * @param: OrderListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response orderList(OrderListCondition orderListCondition) throws Exception;

    /**
     *
     * 功能描述: 列表-查询原料厂商
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response listManufacturer(ListManufacturerCondition listManufacturerCondition);

    /**
     *
     * 功能描述: 查询送货地址（分公司）
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response listAddress(ListManufacturerCondition listManufacturerCondition);

    /**
     *
     * 功能描述: 查询原料
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response listIngredient(ListManufacturerCondition listManufacturerCondition);

    /**
     *
     * 功能描述:订单添加
     *
     * @param: OrderListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    Response orderAdd(OrderAddCondition orderAddCondition)throws Exception;


    /**
     *
     * 功能描述:分后台  列表
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    Response inStoreList(InStoreListCondition inStoreListCondition);

    /**
     *
     * 功能描述:分后台  当天未入库列表
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    Response inStoreToday();
    /**
     *
     * 功能描述:分后台  提交入库
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    Response inStoreInStore(HttpServletRequest request,InStoreInStoreCondition inStoreInStoreCondition);

    /**
     *
     * 功能描述:分后台  输入串码入库
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    Response inStoreNum(HttpServletRequest request,InStoreNumCondition inStoreNumCondition);

    /**
     *
     * 功能描述:分后台  入库记录--列表
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    Response inStoreRecordList(InStoreRecordListCondition inStoreRecordListCondition)throws  Exception;
}
