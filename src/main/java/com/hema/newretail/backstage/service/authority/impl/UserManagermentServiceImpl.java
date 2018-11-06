package com.hema.newretail.backstage.service.authority.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.*;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;
import com.hema.newretail.backstage.entry.RefPostFuncGroup;
import com.hema.newretail.backstage.model.authority.BaseUserInfoBo;
import com.hema.newretail.backstage.service.authority.IUserManagermentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: 程文政
 * @Date: 2018/9/11 10:03
 * @Description:≡(▔﹏▔)≡权限控制模块对于用户权限的管理模块service-interface
 * @Version: 1.0
 */
@Service
public class UserManagermentServiceImpl implements IUserManagermentService {


    /**注入----用户表mapper*/
    @Autowired
    private BaseUserInfoMapper baseUserInfoMapper;

    /**注入----岗位表mapper*/
    @Autowired
    private BasePostMapper basePostMapper;

    /**注入----功能组表mapper*/
    @Autowired
    private BaseFuncGroupMapper baseFuncGroupMapper;

    /**注入----岗位&&功能组表关联表mapper*/
    @Autowired
    private RefPostFuncGroupMapper refPostFuncGroupMapper;

    /**注入----公司表mapper*/
    @Autowired
    private BaseCompanyMapper baseCompanyMapper;


        /**
     * 功能描述: 展示用户管理的用户列表  分页进行展示--数据库检索出所有状态idDelete=0的用户并二次检索出其职位名称
     *
     * @param:Integer pageNum,Integer pageSize
     * @return:BaseUserInfoBo
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response list(Integer pageNum,Integer pageSize) {
        /**分页插件PageHelper*/
        Page<BaseUserInfoEntry> page =PageHelper.startPage(pageNum,pageSize);
        /**自动装填*/
        baseUserInfoMapper.selectAllIsNotDelete();
        List<BaseUserInfoBo> resultList = new ArrayList<>(page.getResult().size());
        /**遍历转换Bo处理*/
        for (BaseUserInfoEntry entry:page.getResult()
             ) {
            BaseUserInfoBo bo = new BaseUserInfoBo();
            /**复制相同字段BeanUtils*/
            BeanUtils.copyProperties(entry, bo);
            if(entry.getPostId() != null){
                bo.setPostName(basePostMapper.selectByPrimaryKey(entry.getPostId()).getPostName());
            }
            resultList.add(bo);
        }
        return Response.success(resultList,page.getTotal(),pageSize,pageNum);
    }

    /**
     * 功能描述: 添加用户----公司展示功能
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response addCompany() {
        return Response.success(baseCompanyMapper.selectAll());
    }

    /**
     * 功能描述: 添加用户----岗位展示
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response addPost() {
        return Response.success(basePostMapper.selectAll());
    }

    /**
     * 功能描述: 添加用户----操作
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response add(BaseUserInfoEntry entry) {
        /**参数拼装*/
        entry.setGmtCreate(new Date());
        entry.setGmtModified(new Date());
        entry.setIsDeleted(false);
        if(baseUserInfoMapper.selectByName(entry.getUserName()) != null){
            return Response.failure("用户名重复，请更换");
        }
        baseUserInfoMapper.insertSelective(entry);
        return Response.success();
    }

    /**
     * 功能描述: 编辑用户---用户详情
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response editDetail(Long id) {
        BaseUserInfoEntry baseUserInfoEntry = baseUserInfoMapper.selectByPrimaryKey(id);
        BaseUserInfoBo bo = new BaseUserInfoBo();
        /**返回值和*/
        BeanUtils.copyProperties(baseUserInfoEntry,bo);
        bo.setBasePost(basePostMapper.selectByPrimaryKey(baseUserInfoEntry.getPostId()));
        bo.setBaseCompanyEntry(baseCompanyMapper.selectByPrimaryKey(baseUserInfoEntry.getCompanyId()));
        return Response.success(bo);
    }


    /**
     *
     * 功能描述: 编辑用户---查询选定岗位的功能组
     *
     * @param:
     * @return:
     * @author: admin
     * @date: 2018/9/13 8:50
     */
    @Override
    public Response editFunction() {
        return Response.success(baseFuncGroupMapper.selectAll());
    }

    /**
     * 功能描述: 编辑用户----保存操作
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response edit(BaseUserInfoEntry entry) {
        entry.setGmtModified(new Date());
        baseUserInfoMapper.updateByPrimaryKeySelective(entry);
        return Response.success();
    }

    /**
     * 功能描述: 删除用户
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/11 10:11
     */
    @Override
    public Response delete(Long id) {
         baseUserInfoMapper.logicDelete(id);
        return Response.success();
    }

    /**
     * 功能描述: 给岗位分配权限
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/12 9:08
     */
    @Override
    public Response grant(String funkGroupCodes,Long postId) {
        List<String> idList = Arrays.asList(funkGroupCodes.split(","));
        for (String funkGroupCode:idList
             ) {
            RefPostFuncGroup refPostFuncGroup = new RefPostFuncGroup();
            refPostFuncGroup.setFuncGroupCode(funkGroupCode);
            refPostFuncGroup.setPostId(postId);
            refPostFuncGroupMapper.insert(refPostFuncGroup);
        }
        return Response.success();
    }

    /**
     * 功能描述: 所有权限列表
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/9/12 9:08
     */
    @Override
    public Response listPermission(Long postId) {
        return Response.success(baseFuncGroupMapper.selectBaseFuncGroupMoudleBo(postId));
    }
}
