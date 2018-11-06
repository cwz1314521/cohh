package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.model.tag.BaseTagEditBo;

/**
 * @Auther: 程文政
 * @Date: 2018/8/20 13:08
 * @Description:
 * @Version: 1.0
 */
public interface ITagService {

    /**查询所有饮品*/
    public Response queryAllDrink(Integer pageNum, Integer pageSize);

    /**查询单个标签内容*/
    public BaseTagEditBo queryOneTag(Long tagId);

    /**返回拼接字符串标签首页*/
    public Response tagJoint(Integer pageNum, Integer pageSize);

    /**标签增*/
    public Response tagAdd(BaseTagEditBo baseTagEditBo);

    /**标签改*/
    public Response tagEdit(BaseTagEditBo baseTagEditBo);
    /**标签改*/
    public Response tagDelete(Long tagId);

}
