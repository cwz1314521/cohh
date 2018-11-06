package com.hema.newretail.backstage.service.drinkmanagement;

import com.hema.newretail.backstage.common.queryparam.diy.*;
import com.hema.newretail.backstage.common.utils.Response;

/**
 * @Department 新零售
 * @ClassName DiySettingService
 * @Description 饮品管理----Diy配料设置  or  diy系统设置
 * @Author ---CWZ
 * @Date 2018/10/17 16:38
 * @Version 1.0
 **/
public interface DiySettingService {

    /**
     *
     * 功能描述: 前端不需要传入参数，返回diy商品折扣前价格
     *
     * @param: null
     * @return: Price diy饮品折扣前价格
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    Response diyPrice();


    /**
     *
     * 功能描述: DIY状态描述设置列表展示
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/17 17:42
     */
    Response diyStatusDescription();

    /**
     *
     * 功能描述: DIY状态描述增加
     *
     * @param: DiyStatusAddEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 18:18
     */
    Response addStatusDescription(DiyStatusAddEditCondition diyStatusAddEditCondition);

    /**
     *
     * 功能描述: DIY状态描述修改
     *
     * @param: DiyStatusAddEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 18:18
     */
    Response editStatusDescription(DiyStatusAddEditCondition diyIdCondition);

    /**
     *
     * 功能描述: DIY状态描述删除
     *
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 9:57
     */
    Response deleteStatusDescription(IdCondition idCondition);

    /**
     *
     * 功能描述: 配料选择---辅助接口
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:30
     */
    Response allIngredient();

    /**
     *
     * 功能描述: 事件列表
     *
     * @param: null or NameCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:30
     */
    Response listEvent(NameCondition nameCondition);

    /**
     *
     * 功能描述:
     *
     * @param: IdCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    Response detailEvent(IdCondition idCondition);

    /**
     *
     * 功能描述:配料事件---编辑添加
     *
     * @param: AddEditEventCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    Response addEditEvent(AddEditEventCondition addEditEventCondition);


    /**
     *
     * 功能描述: 配料事件---删除
     *
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 14:52
     */
    Response deleteEvent(IdCondition idCondition);


    /**
     *
     * 功能描述: 传入参数，修改diy商品折扣前价格
     *
     * @param: string
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    Response editPrice(PriceCondition priceCondition);
}
