package com.hema.newretail.backstage.service.authority;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;

/**
 * @Auther: 程文政
 * @Date: 2018/9/11 10:02
 * @Description:≡(▔﹏▔)≡权限控制模块对于用户权限的管理模块service-interface
 * @Version: 1.0
 */
public interface IUserManagermentService {


    /**
     *
     * 功能描述: 展示用户管理的用户列表  分页进行展示
     *
     * @param: pageNumber,pageSize
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response list(Integer pageNum,Integer pageSize);


    /**
     *
     * 功能描述: 添加用户----公司展示功能
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response addCompany();


    /**
     *
     * 功能描述: 添加用户----岗位展示
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response addPost();


    /**
     *
     * 功能描述: 添加用户----操作
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response add(BaseUserInfoEntry entry);


    /**
     *
     * 功能描述: 编辑用户---用户详情
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response editDetail(Long id);


    /**
     *
     * 功能描述: 编辑用户---查询选定岗位的功能组
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response editFunction();


    /**
     *
     * 功能描述: 编辑用户----保存操作
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response edit(BaseUserInfoEntry entry);


    /**
     *
     * 功能描述: 删除用户
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    Response delete(Long id);

    /**
     *
     * 功能描述: 给岗位分配权限
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/12 9:08
     */
    Response grant(String funkGroupCodes,Long postId);

    /**
     *
     * 功能描述: 所有权限列表
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/12 9:08
     */
    Response listPermission(Long postId);
}
