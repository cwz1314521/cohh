package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.grid.GridListCondition;
import com.hema.newretail.backstage.common.queryparam.grid.LookMapGridCompanyListCondition;
import com.hema.newretail.backstage.entry.grid.GridCompanyEntry;
import com.hema.newretail.backstage.model.grid.GridCompanyListBo;
import com.hema.newretail.backstage.model.grid.GridEditBo;
import com.hema.newretail.backstage.model.grid.GridListBo;
import com.hema.newretail.backstage.model.grid.SubCompanyBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GridCompanyMapper {


    int updatePassword(Long id);


    GridEditBo selectDetail(Long id);


    /**
     * 逻辑删除
     */
    int deleteUpdateById(Long id);

    List<GridListBo> selectGridList(GridListCondition gridListCondition);

    //查询全部信息
    List<GridCompanyEntry> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(GridCompanyEntry record);

    int insertSelective(GridCompanyEntry record);

    GridCompanyEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridCompanyEntry record);

    int updateByPrimaryKey(GridCompanyEntry record);

    /**
     * 查询所有子公司数据
     *
     * @param nameOrCode 公司名称或公司编号（ID）
     * @return 子公司列表
     */
    List<SubCompanyBo> seelctAllSubCompany(@Param("nameOrCode") String nameOrCode, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 根据省市区查询网格公司
     *
     * @param condition 查询条件
     * @return 网格公司
     */
    List<GridCompanyListBo> selectGridCompanyList(@Param("condition") LookMapGridCompanyListCondition condition, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 根据id查询网格公司负责的网格
     *
     * @param companyId 网格公司id
     * @return 网格
     */
    List<String> selectHashcodeByCompanyId(@Param("companyId") Integer companyId);
}