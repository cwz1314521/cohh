package com.hema.newretail.backstage.service.authority.impl;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BasePostMapper;
import com.hema.newretail.backstage.entry.BasePost;
import com.hema.newretail.backstage.enums.ResultCode;
import com.hema.newretail.backstage.service.authority.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.service.impl
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-09-11 11:15
 */
@Service("postService")
public class PostServiceImpl implements IPostService {
    @Autowired
    private BasePostMapper basePostMapper;

    /**
     * 根据条件查询岗位信息
     *
     * @param paramsMap 参数
     * @return list
     */
    @Override
    public List<BasePost> queryDataByCondition(Map<String, Object> paramsMap) {
        return basePostMapper.selectPostByCondition((Integer) paramsMap.get("pageNum"), (Integer) paramsMap.get("pageSize"));
    }

    /**
     * 添加岗位信息
     *
     * @param data 对象
     * @return 结果集
     */
    @Override
    public Response insertData(BasePost data) {
        int num = basePostMapper.selectPostExistByPostName(data.getPostName());
        if (0 == num) {
            data.setGmtCreate(new Date());
            data.setIsDeleted(false);
            basePostMapper.insert(data);
            return Response.success();
        } else {
            return Response.failure(ResultCode.VALIDATION_ERROR_DATA_EXIST);
        }
    }

    /**
     * 更新岗位信息
     *
     * @param data 对象
     * @return 结果集
     */
    @Override
    public Response updateData(BasePost data) {
        BasePost post = basePostMapper.selectByPrimaryKey(data.getId());
        if (null == post) {
            return Response.failure();
        }
        // 修改的对象
        post.setPostDesc(data.getPostDesc());
        post.setPostName(data.getPostName());
        post.setGmtModified(new Date());
        basePostMapper.updateByPrimaryKey(post);
        return Response.success();
    }

    /**
     * 删除一条数据
     *
     * @param postId 岗位ID
     * @return 删除的条数
     */
    @Override
    public int deleteData(String postId) {
        return basePostMapper.deleteByPrimaryKey(Long.valueOf(postId));
    }
}
