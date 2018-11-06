package com.hema.newretail.backstage.service.grid;

import com.hema.newretail.backstage.common.queryparam.grid.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.model.grid.GridCompanyListBo;
import com.hema.newretail.backstage.model.grid.SubCompanyBo;

import java.util.List;
import java.util.Map;

/**
 * @Department 新零售
 * @ClassName GridService
 * @Description 网格公司管理service接口类
 * @Author ---CWZ
 * @Date 2018/9/21 16:29
 * @Version 1.0
 **/
public interface GridService {



    /**
     *
     * 功能描述: 网格公司列表，分页显示
     *
     * @param: pageNum ：页数，pageSize ：每页最大数，name ：名称，province ：省，city ：市，area ：区，status ：状态
     * @return:
     * @author: cwz
     * @date: 2018/9/21 16:09
     */

    Response list(GridListCondition gridListCondition);

    /**
     *
     * 功能描述:添加网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response addGrid(GridAddCondition gridAddCondition);



    /**
     *
     * 功能描述:修改网格公司详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response editGridDetail(Long companyId);

    /**
     * 功能描述:重置密码
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    Response updatePassword(Long id);

    /**
     *
     * 功能描述:修改网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

   Response editGrid(GridEditCondition gridEditCondition);

    /**
     *
     * 功能描述:删除网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response delete(Long companyId);

    /**
     *
     * 功能描述:积分管理
     *
     * @param: id ：主键，
     *   type ：操作类型，
     *   reason ：操作原因，
     *   integral ：积分，
     *   remark ：备注
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response integral(GridIntegralCondition gridIntegralCondition);

    /**
     *
     * 功能描述:积分记录
     *
     * @param: id
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response integralRecord(GridIntegralRecordCondition gridIntegralRecordCondition);

    /**
     *
     * 功能描述:服务网格
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response serviceEdit(ServiceCondition serviceCondition);


    /**
     * 功能描述:服务网格
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    Response service(GridDeleteCondition condition);

    /**
     *
     * 功能描述:网格数据列表，分页显示
     *
     * @param: pageNum ：页数，
     *    pageSize ：每页最大数，
     *    name ：名称，
     *    province ：省，
     *    city ：市，
     *    area ：区，
     *    status ：状态
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response listData();

    /**
     *
     * 功能描述:网格任务列表，分页显示
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response listTask(GridListTaskCondition gridListTaskCondition) throws Exception;

    /**
     * 功能描述:网格任务详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    Response detailTask(Long id) throws Exception;
    /**
     *
     * 功能描述:绩效模式列表
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response listPref();

    /**
     *
     * 功能描述:绩效增加
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response addPref(GridPrefCondition gridPrefCondition);

    /**
     *
     * 功能描述:绩效更改
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response editPref(GridPrefEditCondition gridPrefEditCondition);

    /**
     *
     * 功能描述:绩效模式删除
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */

    Response deletePref(Long id);

    /**
     * 查询所有子公司数据
     *
     * @param nameOrCode 公司名称或公司编号（ID）
     * @return 子公司列表
     */
    List<SubCompanyBo> subCompanys(String nameOrCode, Integer pageNum, Integer pageSize);

    /**
     * 根据省市区查询网格公司
     *
     * @param condition 查询条件
     * @return 网格公司
     */
    List<GridCompanyListBo> queryGridCompanyList(LookMapGridCompanyListCondition condition);

    /**
     * 根据查询条件查询网格公司负责的网格
     *
     * @param condition 查询条件
     * @return 网格和设备数量
     */
    Map<String, Object> queryHashcodeByCompanyId(LookMapCondition condition);
}
