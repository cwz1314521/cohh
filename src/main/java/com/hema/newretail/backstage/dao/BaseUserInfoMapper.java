package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseUserInfoEntry;

import java.util.List;

public interface BaseUserInfoMapper {


    /**
     *
     * 功能描述: 逻辑删除
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 13:56
     */
    int logicDelete(Long id);
    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 11:07
     */
    List<BaseUserInfoEntry> selectAll();

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 11:07
     */
    List<BaseUserInfoEntry> selectAllIsNotDelete();

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 11:07
     */
    List<BaseUserInfoEntry> selectAllIsDelete();

    int deleteByPrimaryKey(Long id);

    BaseUserInfoEntry selectByName(String userName);

    int insert(BaseUserInfoEntry record);

    int insertSelective(BaseUserInfoEntry record);

    BaseUserInfoEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseUserInfoEntry record);

    int updateByPrimaryKey(BaseUserInfoEntry record);

    BaseUserInfoEntry findOneByCompanyId(Long id);

}