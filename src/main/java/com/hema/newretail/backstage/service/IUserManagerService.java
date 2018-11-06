package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.UserManagerData;

import java.util.List;
import java.util.Map;

public interface IUserManagerService {

    public UserManagerData queryOneById(String id);

    public Response getUserConsumptionsByOpenId(Map<String,Object> paramperters);

    public boolean updateStatusById(String id);

    public List<UserManagerData> findAll(UserManaCondition userManaCondition);

}
