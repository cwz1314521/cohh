package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.dao.BaseUserInfoMapper;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;
import com.hema.newretail.backstage.service.IBaseUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户基本信息服务接口实现类
 * @Author: Mr.Yang
 * @Date: 2018/09/25
 **/
@Service("baseUserInfoService")
public class BaseUserInfoServiceImpl implements IBaseUserInfoService {

    @Autowired
    private BaseUserInfoMapper baseUserInfoMapper;

    @Override
    public int initUserPassWord(BaseUserInfoEntry data) {
        return baseUserInfoMapper.updateByPrimaryKeySelective(data);
    }

    @Override
    public BaseUserInfoEntry findOneByCompanyId(Long companyId) {
        return baseUserInfoMapper.findOneByCompanyId(companyId);
    }
}
