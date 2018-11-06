package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;

/**
 * @Auther: 程文政
 * @Date: 2018/8/21 15:39
 * @Description:
 * @Version: 1.0
 */
public interface IUserManagementService {

    /*用户条件查询*/
    public Response paginationQuery(UserManaCondition userManaCondition) throws Exception;

    /*批量冻结*/
    public Response batchFreeze(String ids);

    /*批量解冻*/
    public Response batchRelease (String ids);
}
