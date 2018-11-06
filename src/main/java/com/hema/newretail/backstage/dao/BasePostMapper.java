package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BasePost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author z
 */
public interface BasePostMapper {
    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加
     *
     * @param record 对象
     * @return 添加的记录数
     */
    int insert(BasePost record);

    /**
     * 添加
     *
     * @param record 对象
     * @return 添加的记录数
     */
    int insertSelective(BasePost record);

    /**
     * 根据主键查询一条记录
     *
     * @param id 主键
     * @return BasePost
     */
    BasePost selectByPrimaryKey(Long id);

    /**
     * 根据主键更新一条记录
     *
     * @param record 对象
     * @return 更新的记录条数
     */
    int updateByPrimaryKeySelective(BasePost record);

    /**
     * 根据主键更新一条记录
     *
     * @param record 对象
     * @return 更新的记录条数
     */
    int updateByPrimaryKey(BasePost record);

    /**
     * 根据条件查询岗位信息
     *
     * @param pageNum  页码
     * @param pageSize 每页显示的数据数量
     * @return List
     */
    List<BasePost> selectPostByCondition(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**
     *
     * 功能描述:查询全部
     *
     * @param
     * @return list
     * @author admin
     * @date 2018/9/12 10:48
     */
    List<BasePost> selectAll();
    /**
     * 查询岗位是否存在
     *
     * @param postName 岗位名称
     * @return 0 不存在 大于0 存在
     */
    int selectPostExistByPostName(String postName);
}

