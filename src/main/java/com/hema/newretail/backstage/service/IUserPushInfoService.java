package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.PushInfoData;
import com.hema.newretail.backstage.entry.UserFormIdData;

import java.util.List;
import java.util.Map;

public interface IUserPushInfoService {
    public Response findAll(Map<String,Object> params);
    public PushInfoData findOne(String id);
    public void save(PushInfoData data);
    public void saveFormId(UserFormIdData data);
    public UserFormIdData findOneByOpenId(String openId);
    public String getAccessToken();
    public String sendTemplate(String touser, String formId, String[] fillData);
    public void deleteFormIdData(String formId);
}
