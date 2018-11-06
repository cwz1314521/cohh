package com.hema.newretail.backstage.service.authority;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BasePost;

import java.util.List;
import java.util.Map;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.service
 *
 * @author ZhangHaiSheng
 * @date 2018-09-11 11:14
 */
public interface IPostService {

    /**
     * 根据条件查询岗位信息
     *
     * @param paramsMap 参数
     * @return list
     */
    List<BasePost> queryDataByCondition(Map<String, Object> paramsMap);

    /**
     * 添加岗位信息
     *
     * @param data 对象
     * @return 结果集
     */
    Response insertData(BasePost data);

    /**
     * 更新岗位信息
     *
     * @param data 对象
     * @return 结果集
     */
    Response updateData(BasePost data);

    /**
     * 删除一条岗位数据
     *
     * @param postId 岗位ID
     * @return 删除的条数
     */
    int deleteData(String postId);
}
