package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.entry.BaseUserInfoEntry;

/**
 * @Description: 用户基本信息服务接口
 * @Author: Mr.Yang
 * @Date: 2018/09/25
 **/
public interface IBaseUserInfoService {

    BaseUserInfoEntry findOneByCompanyId(Long id);

    int initUserPassWord(BaseUserInfoEntry data);
}
