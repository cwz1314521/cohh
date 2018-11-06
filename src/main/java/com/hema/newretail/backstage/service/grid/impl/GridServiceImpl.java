package com.hema.newretail.backstage.service.grid.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.grid.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.utils.StringUtil;
import com.hema.newretail.backstage.common.utils.TimeUtil;
import com.hema.newretail.backstage.common.utils.ossutil.AliyunOSSClientUtil;
import com.hema.newretail.backstage.dao.*;
import com.hema.newretail.backstage.entry.BaseGlobalInfoEntry;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.entry.BusiCompanyAccountEntry;
import com.hema.newretail.backstage.entry.grid.*;
import com.hema.newretail.backstage.model.grid.*;
import com.hema.newretail.backstage.service.grid.GridService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Department 新零售
 * @ClassName GridServiceImpl
 * @Description 网格公司管理service接口实现类
 * @Author ---CWZ
 * @Date 2018/9/21 16:29
 * @Version 1.0
 **/
@Service
public class GridServiceImpl implements GridService {

    @Autowired
    private AliyunOSSClientUtil aliyunOSSClientUtil;

    @Autowired
    private GridCompanyMapper gridCompanyMapper;

    @Autowired
    private GridIntegralRuleMapper gridIntegralRuleMapper;

    @Autowired
    private GridCompanyGeohashMapper gridCompanyGeohashMapper;

    @Autowired
    private GridIntegralRecordMapper gridIntegralRecordMapper;

    @Autowired
    private GridTasksMapper gridTasksMapper;


    @Autowired
    private GridKpiModeMapper gridKpiModeMapper;

    @Autowired
    private BusiCompanyAccountMapper busiCompanyAccountMapper;

    @Autowired
    private BaseMachineBoxLogMapper baseMachineBoxLogMapper;

    @Autowired
    private BaseIngredientInfoEntryMapper baseIngredientInfoEntryMapper;

    @Autowired
    private BaseGlobalInfoMapper baseGlobalInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);


    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
    private final static String EMPTY ="";
    private final static String VERSION = "version";
    private final static String BOXCODE = "boxCode";
    private final static String ERRORCODE = "errorCode";
    private final static String TASKCONTENT = "taskContent";

    /**
     * 功能描述: 网格公司列表，分页显示
     *
     * @param: pageNum ：页数，pageSize ：每页最大数，name ：名称，province ：省，city ：市，area ：区，status ：状态
     * @return:
     * @author: cwz
     * @date: 2018/9/21 16:09
     */
    @Override
    public Response list(GridListCondition gridListCondition) {
        logger.info("网格公司列表参数处理......");
        gridListCondition = listCondition(gridListCondition);
        /*判断名字编号是否为空   不为空判断是否为数字  若为数字转化为id 清空name*/
        logger.info("判断name是否存在......"+gridListCondition.getName());
        if(gridListCondition.getName() != "" && gridListCondition.getName() !=null){
            if(isInteger(gridListCondition.getName())){
                logger.info("name由数字构成转化为Id"+gridListCondition.getName());
                gridListCondition.setId(Long.parseLong(gridListCondition.getName()));
                gridListCondition.setName(null);
            }
        }
        logger.info("加入分页查询数据库");
        Page<GridListBo> page =PageHelper.startPage(gridListCondition.getPageNum(), gridListCondition.getPageSize());
        gridCompanyMapper.selectGridList(gridListCondition);
        List<GridListBo> list = page.getResult();
        return Response.success(list,page.getTotal(),page.getPageSize(),page.getPageNum());
    }

    /**
     * 功能描述:添加网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    @Transactional
    public Response addGrid(GridAddCondition gridAddCondition) {
        /*拼装参数*/
        logger.info("网格主表存储......");
        GridCompanyEntry gridCompanyEntry = addGridCompanyEntry(gridAddCondition);
        gridCompanyMapper.insert(gridCompanyEntry);
        logger.info("规则表存储......");
        GridIntegralRuleEntry gridIntegralRuleEntry = addGridIntegralRuleEntry(gridAddCondition);
        gridIntegralRuleEntry.setGridCompanyId(gridCompanyEntry.getId());
        gridIntegralRuleMapper.insert(gridIntegralRuleEntry);
        logger.info("账户表存储......");
        BusiCompanyAccountEntry busiCompanyAccountEntry = new BusiCompanyAccountEntry();
        busiCompanyAccountEntry.setType("0");
        busiCompanyAccountEntry.setRefId(gridCompanyEntry.getId());
        busiCompanyAccountEntry.setGmtModified(new Date());
        busiCompanyAccountEntry.setGmtCreate(new Date());
        busiCompanyAccountEntry.setBank(gridAddCondition.getBank());
        busiCompanyAccountEntry.setAccountName(gridAddCondition.getAccountName());
        busiCompanyAccountEntry.setAccountNumber(gridAddCondition.getAccountNumber());
        busiCompanyAccountMapper.insert(busiCompanyAccountEntry);
        Map<String, Object> map = new HashMap<>(1);
        map.put("gridCompanyId", gridCompanyEntry.getId());
        return Response.success(map);
    }

    /**
     * 功能描述:修改网格公司详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response editGridDetail(Long companyId){
        logger.info("查询id为"+companyId+"的详情......");
        return Response.success(gridCompanyMapper.selectDetail(companyId));
    }

    /**
     * 功能描述:重置密码
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response updatePassword(Long id){
        logger.info("重置id为"+id+"的密码......");
        return Response.success(gridCompanyMapper.updatePassword(id));
    }

    /**
     * 功能描述:修改网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    @Transactional
    public Response editGrid(GridEditCondition gridEditCondition) {
        logger.info("主表更新......");
        GridCompanyEntry gridCompanyEntry = editGridCompanyEntry(gridEditCondition);
        gridCompanyMapper.updateByPrimaryKeySelective(gridCompanyEntry);
        logger.info("规则表参数拼装......");
        GridIntegralRuleEntry gridIntegralRuleEntry = editGridIntegralRuleEntry(gridEditCondition);
        gridIntegralRuleEntry.setGridCompanyId(gridCompanyEntry.getId());
        List<GridIntegralRuleEntry> list = gridIntegralRuleMapper.selectByCompany(gridCompanyEntry.getId());
        logger.info("判断规则条数......");
        if(list.size() > 1){
            logger.info("判断最新一条是否生效......");
            if(list.get(0).getEffectiveTime().getTime() > System.currentTimeMillis()){
                logger.info("未生效，删除本条信息，新增一条规则......");
                gridIntegralRuleMapper.deleteByPrimaryKey(list.get(0).getId());
                gridIntegralRuleMapper.insert(gridIntegralRuleEntry);
            }else {
                logger.info("已生效，删除上条信息，新增一条规则......");
                gridIntegralRuleMapper.deleteByPrimaryKey(list.get(1).getId());
                gridIntegralRuleMapper.insert(gridIntegralRuleEntry);
            }

        }else {
            logger.info("只有一条数据，新增一条信息......");
            gridIntegralRuleMapper.insert(gridIntegralRuleEntry);
        }
        logger.info("拼装账户信息并存储......");
        BusiCompanyAccountEntry busiCompanyAccountEntry = new BusiCompanyAccountEntry();
        busiCompanyAccountEntry.setType("0");
        busiCompanyAccountEntry.setRefId(gridCompanyEntry.getId());
        busiCompanyAccountEntry.setGmtModified(new Date());
        busiCompanyAccountEntry.setBank(gridEditCondition.getBank());
        busiCompanyAccountEntry.setAccountName(gridEditCondition.getAccountName());
        busiCompanyAccountEntry.setAccountNumber(gridEditCondition.getAccountNumber());
        busiCompanyAccountMapper.updateByRefIdSelective(busiCompanyAccountEntry);
        return Response.success();
    }

    /**
     * 功能描述:删除网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response delete(Long companyId) {
        List<GridCompanyGeohashEntry> list = gridCompanyGeohashMapper.selectByCompanyId(companyId);
        if(list.size() > 0){
            return Response.failure("本公司还有关联的网格区域，请调整后再删除");
        }else {
            gridCompanyMapper.deleteUpdateById(companyId);
            return Response.success();
        }
    }

    /**
     * 功能描述:积分管理
     *
     * @param: id ：主键，
     * type ：操作类型，
     * reason ：操作原因，
     * integral ：积分，
     * remark ：备注
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response integral(GridIntegralCondition gridIntegralCondition) {
        GridIntegralRecordEntry gridIntegralRecordEntry = IntegralGridIntegralRecordEntry(gridIntegralCondition);
        gridIntegralRecordMapper.insert(gridIntegralRecordEntry);
        return Response.success();
    }

    /**
     * 功能描述:积分记录
     *
     * @param: id
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response integralRecord(GridIntegralRecordCondition gridIntegralRecordCondition) {
        Page<GridIntegralRecordEntry> page =PageHelper.startPage(gridIntegralRecordCondition.getPageNum(), gridIntegralRecordCondition.getPageSize());
        gridIntegralRecordMapper.selectByGridCompanyId(gridIntegralRecordCondition.getGridCompanyId());
        return Response.success(page.getResult(),page.getTotal(),gridIntegralRecordCondition.getPageSize(),gridIntegralRecordCondition.getPageNum());
    }

    /**
     * 功能描述:服务网格操作
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response serviceEdit(ServiceCondition serviceCondition) {
        GridCompanyGeohashEntry gridCompanyGeohashEntry = new GridCompanyGeohashEntry();
        List<String> list = StringUtil.StringsToString(serviceCondition.getGeoHashs());
        gridCompanyGeohashMapper.deleteByCompanyId(serviceCondition.getGridCompanyId());
        for (String hashcode : list) {
            if(StringUtils.isEmpty(hashcode)) {
                continue;
            }
            gridCompanyGeohashEntry.setGeoHashCode(hashcode);
            gridCompanyGeohashEntry.setGridCompanyId(serviceCondition.getGridCompanyId());
            Map<String, Object> paramsMap = new HashMap<>(2);
            paramsMap.put("gridCompanyId", serviceCondition.getGridCompanyId());
            paramsMap.put("geoHashCode", hashcode);
            Long num = gridCompanyGeohashMapper.selectCountByIdAndHashcode(paramsMap);
            if (null != num && 0 == num) {
                gridCompanyGeohashMapper.insert(gridCompanyGeohashEntry);
            }
        }
        return Response.success();
    }

    /**
     * 功能描述:服务网格
     *
     * @param condition
     * @return
     */
    @Override
    public Response service(GridDeleteCondition condition) {
        Integer machineNum = 0;
        String suffix = ".json";
        Map<String, Object> result = new HashMap<>();

        List<GeoAndMachineNumBo> list = new ArrayList<>();
        /*
         * 地图可视范围内的网格
         */
        List<String> allGeoHash = new ArrayList<>(condition.getMapGeoHash());
        /*
         * 已经分配给网格公司的网格
         */
        List<String> usedGeoHash = gridCompanyGeohashMapper.freeGeoHash(condition.getMapGeoHash());
        /*
          当前网格公司的网格
         */
        List<String> gridCompanyGeoHash = gridCompanyGeohashMapper.findGridCompanyGeoHashByCompanyId(condition.getId());
        /*
         * 分给其他网格公司的网格
         */
        if (null != gridCompanyGeoHash && gridCompanyGeoHash.size() > 0) {
            usedGeoHash.removeAll(gridCompanyGeoHash);
        }

        allGeoHash.removeAll(usedGeoHash);
        for (String geo : allGeoHash) {
            String fileName = geo + suffix;
            String str = aliyunOSSClientUtil.readStreamFileOfJson(fileName);
            GeoAndMachineNumBo bo = new GeoAndMachineNumBo();
            bo.setGeoHashCode(geo);
            if (!StringUtils.isEmpty(str)) {
                JSONArray jsonArray = JSONArray.parseArray(str);
                Integer num = jsonArray.size();
                bo.setNum(num);
                machineNum += num;
            } else {
                bo.setNum(0);
            }
            list.add(bo);
        }
        result.put("otherCompanyGeoHash", usedGeoHash);
        result.put("gridCompanyGeoHash", gridCompanyGeoHash);
        result.put("allCompanyGeoHash", list);
        result.put("machineNums", machineNum);
        return Response.success(result);
    }


    /**
     * 功能描述:网格数据列表，分页显示
     *
     * @param: pageNum ：页数，
     * pageSize ：每页最大数，
     * name ：名称，
     * province ：省，
     * city ：市，
     * area ：区，
     * status ：状态
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response listData() {
        return null;
    }

    /**
     * 功能描述:网格任务列表，分页显示
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response listTask(GridListTaskCondition gridListTaskCondition) throws Exception{
        gridListTaskCondition = gridListTaskCondition(gridListTaskCondition);
        Page<GridTaskBo> page =PageHelper.startPage(gridListTaskCondition.getPageNum(),gridListTaskCondition.getPageSize());
        gridTasksMapper.selectTaskByCondition(gridListTaskCondition);
        return Response.success(page.getResult(),page.getTotal(),gridListTaskCondition.getPageSize(),gridListTaskCondition.getPageNum());
    }

    /**
     * 功能描述:网格任务详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response detailTask(Long id) throws Exception{
        GridTaskBo gridTaskBo = gridTasksMapper.selectEditById(id);
        gridTaskBo.setTimess(TimeUtil.timeQuantum(gridTaskBo.getTimes()));
        if(gridTaskBo.getTaskDetails() != null){
            JSONObject jsStr = JSONObject.parseObject(gridTaskBo.getTaskDetails());
            StringBuffer details = new StringBuffer();
            /*详情拼装*/
            /*判断是不是补货*/
            if(jsStr.get(VERSION) != null){
                /*判断是机器补货还是人补货0补料 1换料 assigner补货*/
                if(gridTaskBo.getAssigner() == 0){
                    details.append("补料:");
                    List<BoxLogBo> list = baseMachineBoxLogMapper.selectByCreate(Long.valueOf(String.valueOf(jsStr.get(VERSION))).longValue());
                    List<Integer> ss = StringUtil.StringsToInteger(jsStr.get(BOXCODE).toString());
                    for (Integer a:ss
                         ) {
                        for (BoxLogBo b:list
                             ) {
                            if(a == b.getBoxCode()){
                                details.append("料盒[").append(a).append("]--[").append(b.getIngredientName()).append("].");
                            }
                        }
                    }
                }else if (gridTaskBo.getAssigner() == 1){
                    details.append("换料:");
                    Map<Long,String> map = new HashMap<>();
                    List<BaseIngredientInfoEntry> baseIngredientInfoEntries = baseIngredientInfoEntryMapper.selectAll();
                    for (BaseIngredientInfoEntry b:baseIngredientInfoEntries
                         ) {
                        map.put(b.getId(),b.getIngredientName());
                    }
                    JSONArray array = jsStr.getJSONArray("oldIngredientBoxRef");
                    JSONArray array1 = jsStr.getJSONArray("newIngredientBoxRef");
                    for (int i = 0;i<array.size();i++){
                        details.append("料盒[").
                                append(array.getJSONObject(i).get(BOXCODE)).
                                append("]由[").append(map.get(Long.valueOf(String.valueOf(array.getJSONObject(i).get("ingredientId"))).longValue())).
                                append("]更换成[").append(map.get(Long.valueOf(String.valueOf(array1.getJSONObject(i).get("ingredientId"))).longValue())).
                                append("].");
                    }
                }
            }else {
                if(jsStr.get(ERRORCODE) != null){
                    BaseGlobalInfoEntry entry = baseGlobalInfoMapper.selectByKey(jsStr.get(ERRORCODE).toString());
                    details.append("设备出现了[").append(entry.getValue()).append("]故障");
                }
                if(jsStr.get(TASKCONTENT) != null){
                    details.append(jsStr.get(TASKCONTENT));
                }
            }
            //Bassegroupinfo  异常状态码
            //base_machine_box_log  根据version找到
            gridTaskBo.setTaskDetails(details.toString());
        }
        return Response.success(gridTaskBo);
    }

    /**
     * 功能描述:绩效模式列表
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response listPref() {
        return Response.success(gridKpiModeMapper.selectAll());
    }

    /**
     * 功能描述:绩效增加
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response addPref(GridPrefCondition gridPrefCondition) {
        GridKpiModeEntry gridKpiModeEntry = addPrefEntry(gridPrefCondition);
        if(gridKpiModeEntry.getDensityRangeMax() <= gridKpiModeEntry.getDensityRangeMin()){
            return Response.failure("密度范围输入有误");
        }
        gridKpiModeMapper.insert(gridKpiModeEntry);
        return Response.success();
    }

    /**
     * 功能描述:绩效更改
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response editPref(GridPrefEditCondition gridPrefEditCondition) {
        GridKpiModeEntry gridKpiModeEntry = addPrefEntry(gridPrefEditCondition);
        if(gridKpiModeEntry.getDensityRangeMax() <= gridKpiModeEntry.getDensityRangeMin()){
            return Response.failure("密度范围输入有误");
        }
        gridKpiModeMapper.updateByPrimaryKeySelective(gridKpiModeEntry);
        return Response.success();
    }

    /**
     * 功能描述:绩效模式删除
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @Override
    public Response deletePref(Long id) {
        gridKpiModeMapper.deleteByPrimaryKey(id);
        return Response.success();
    }

    /**
     * 查询所有子公司数据
     *
     * @param nameOrCode 公司名称或公司编号（ID）
     * @return 子公司列表
     */
    @Override
    public List<SubCompanyBo> subCompanys(String nameOrCode, Integer pageNum, Integer pageSize) {
        return gridCompanyMapper.seelctAllSubCompany(nameOrCode, pageNum, pageSize);
    }

    @Override
    public List<GridCompanyListBo> queryGridCompanyList(LookMapGridCompanyListCondition condition) {
        return gridCompanyMapper.selectGridCompanyList(condition, condition.getPageNum(), condition.getPageSize());
    }

    @Override
    public Map<String, Object> queryHashcodeByCompanyId(LookMapCondition condition) {
        int machineNum = 0;
        String suffix = ".json";
        Map<String, Object> result = new HashMap<>();
        List<String> hashCodes = gridCompanyMapper.selectHashcodeByCompanyId(Integer.valueOf(condition.getCompanyId()));
        for (String geo : hashCodes) {
            String fileName = geo + suffix;
            String str = aliyunOSSClientUtil.readStreamFileOfJson(fileName);
            if (!StringUtils.isEmpty(str)) {
                JSONArray jsonArray = JSONArray.parseArray(str);
                machineNum += jsonArray.size();
            }
        }
        result.put("hashCodes", hashCodes);
        result.put("machineNum", machineNum);
        return result;
    }

    /**
     *
     * 功能描述: 判断传入的name是否由数字构成
     *
     * @param: str
     * @return: boolean
     * @author: cwz
     * @date: 2018/9/25 12:00
     */
    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    /**
     *
     * 功能描述: 添加网格公司参数拼装
     *
     * @param: GridAddCondition
     * @return: GridCompanyEntry
     * @author: cwz
     * @date: 2018/9/27 11:41
     */
    private GridCompanyEntry editGridCompanyEntry(GridEditCondition gridEditCondition){
        GridCompanyEntry gridCompanyEntry = new GridCompanyEntry();
        gridCompanyEntry.setId(gridEditCondition.getId());
        gridCompanyEntry.setCompanyId(gridEditCondition.getCompanyId());
        gridCompanyEntry.setUserName(gridEditCondition.getUserName());
        gridCompanyEntry.setContactWay(gridEditCondition.getContactWay());
        gridCompanyEntry.setContact(gridEditCondition.getContact());
        gridCompanyEntry.setProvince(gridEditCondition.getProvince());
        gridCompanyEntry.setCity(gridEditCondition.getCity());
        gridCompanyEntry.setArea(gridEditCondition.getArea());
        gridCompanyEntry.setAddr(gridEditCondition.getAddr());
        gridCompanyEntry.setStatus(gridEditCondition.getStatus());
        gridCompanyEntry.setRemark(gridEditCondition.getRemark());
        gridCompanyEntry.setGmtModified(new Date());

        return gridCompanyEntry;
    }
    /**
     *
     * 功能描述: 添加网格公司参数拼装
     *
     * @param: GridAddCondition
     * @return: GridCompanyEntry
     * @author: cwz
     * @date: 2018/9/27 11:41
     */
    private GridCompanyEntry addGridCompanyEntry(GridAddCondition gridAddCondition){
        GridCompanyEntry gridCompanyEntry = new GridCompanyEntry();
        gridCompanyEntry.setPassword(gridAddCondition.getPassword());
        gridCompanyEntry.setCompanyId(gridAddCondition.getCompanyId());
        gridCompanyEntry.setCompanyName(gridAddCondition.getCompanyName());
        gridCompanyEntry.setUserName(gridAddCondition.getUserName());
        gridCompanyEntry.setContactWay(gridAddCondition.getContactWay());
        gridCompanyEntry.setContact(gridAddCondition.getContact());
        gridCompanyEntry.setProvince(gridAddCondition.getProvince());
        gridCompanyEntry.setCity(gridAddCondition.getCity());
        gridCompanyEntry.setArea(gridAddCondition.getArea());
        gridCompanyEntry.setAddr(gridAddCondition.getAddr());
        gridCompanyEntry.setStatus(gridAddCondition.getStatus());
        gridCompanyEntry.setRemark(gridAddCondition.getRemark());


        gridCompanyEntry.setGmtCreate(new Date());
        gridCompanyEntry.setGmtModified(new Date());
        gridCompanyEntry.setIsDeleted(false);

        return gridCompanyEntry;
    }

    /**
     *
     * 功能描述: 添加绩效规则参数拼装
     *
     * @param: GridAddCondition
     * @return: GridIntegralRuleEntry
     * @author: cwz
     * @date: 2018/9/27 11:41
     */
    private GridIntegralRuleEntry addGridIntegralRuleEntry(GridAddCondition gridAddCondition){
        GridIntegralRuleEntry gridIntegralRuleEntry = new GridIntegralRuleEntry();
        gridIntegralRuleEntry.setRewardAmount(gridAddCondition.getRewardAmount());
        gridIntegralRuleEntry.setReplenishmentTime(gridAddCondition.getReplenishmentTime());
        gridIntegralRuleEntry.setCleanupReward(gridAddCondition.getCleanupReward());
        gridIntegralRuleEntry.setReplaceReward(gridAddCondition.getReplaceReward());
        gridIntegralRuleEntry.setMaintenanceReward(gridAddCondition.getMaintenanceReward());
        gridIntegralRuleEntry.setInspectionReward(gridAddCondition.getInspectionReward());
        gridIntegralRuleEntry.setGmtCreate(new Date());
        gridIntegralRuleEntry.setEffectiveTime(new Date());
        return gridIntegralRuleEntry;
    }

    /**
     *
     * 功能描述: 修改绩效规则参数拼装
     *
     * @param: GridAddCondition
     * @return: GridIntegralRuleEntry
     * @author: cwz
     * @date: 2018/9/27 11:41
     */
    private GridIntegralRuleEntry editGridIntegralRuleEntry(GridEditCondition gridEditCondition){
        GridIntegralRuleEntry gridIntegralRuleEntry = new GridIntegralRuleEntry();
        gridIntegralRuleEntry.setRewardAmount(gridEditCondition.getRewardAmount());
        gridIntegralRuleEntry.setReplenishmentTime(gridEditCondition.getReplenishmentTime());
        gridIntegralRuleEntry.setCleanupReward(gridEditCondition.getCleanupReward());
        gridIntegralRuleEntry.setReplaceReward(gridEditCondition.getReplaceReward());
        gridIntegralRuleEntry.setMaintenanceReward(gridEditCondition.getMaintenanceReward());
        gridIntegralRuleEntry.setInspectionReward(gridEditCondition.getInspectionReward());
        gridIntegralRuleEntry.setGmtCreate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        gridIntegralRuleEntry.setEffectiveTime(calendar.getTime());
        return gridIntegralRuleEntry;
    }
    /**
     *
     * 功能描述: 积分管理参数类参数拼装
     *
     * @param:
     * @return:GridIntegralRecordEntry
     * @author: cwz
     * @date: 2018/9/27 17:52
     */
    private GridIntegralRecordEntry IntegralGridIntegralRecordEntry(GridIntegralCondition gridIntegralCondition) {
        GridIntegralRecordEntry gridIntegralRecordEntry = new GridIntegralRecordEntry();

        gridIntegralRecordEntry.setGridCompanyId(gridIntegralCondition.getGridCompanyId());
        gridIntegralRecordEntry.setIntegral(gridIntegralCondition.getIntegral());
        gridIntegralRecordEntry.setOpType(gridIntegralCondition.getOpType());
        gridIntegralRecordEntry.setOpReason(gridIntegralCondition.getOpReason());
        gridIntegralRecordEntry.setOpName(gridIntegralCondition.getOpName());
        gridIntegralRecordEntry.setRemark(gridIntegralCondition.getRemark());
        gridIntegralRecordEntry.setGmtCreate(new Date());
        gridIntegralRecordEntry.setGmtModified(new Date());
        return gridIntegralRecordEntry;
    }


    /**
     *
     * 功能描述: 任务列表参数拼装
     *
     * @param:GridListTaskCondition
     * @return:GridListTaskCondition
     * @author: cwz
     * @date: 2018/9/29 17:52
     */
    private GridListTaskCondition gridListTaskCondition(GridListTaskCondition gridListTaskCondition) throws Exception {
        if(EMPTY.equals(gridListTaskCondition.getTaskCode())){
            gridListTaskCondition.setTaskCode(null);
        }
        if(EMPTY.equals(gridListTaskCondition.getTaskStatus())){
            gridListTaskCondition.setTaskStatus(null);
        }
        if(EMPTY.equals(gridListTaskCondition.getCity())){
            gridListTaskCondition.setCity(null);
        }
        if(EMPTY.equals(gridListTaskCondition.getProvince())){
            gridListTaskCondition.setProvince(null);
        }
        if(gridListTaskCondition.getArea()!=null && gridListTaskCondition.getArea().length == 0){
            gridListTaskCondition.setArea(null);
        }
        if(EMPTY.equals(gridListTaskCondition.getPreAssignTimes())){
            gridListTaskCondition.setPreAssignTime(null);
        }else {
            if(gridListTaskCondition.getPreAssignTimes() !=null){
                gridListTaskCondition.setPreAssignTime(sdf.parse(gridListTaskCondition.getPreAssignTimes()));
            }
        }
        if(EMPTY.equals(gridListTaskCondition.getAssignTimes())){
            if(EMPTY.equals(gridListTaskCondition.getPreAssignTimes())){
                gridListTaskCondition.setAssignTime(null);
            }else {
                gridListTaskCondition.setAssignTime(new Date());
            }
        }else {
            if(gridListTaskCondition.getAssignTimes() != null){
                gridListTaskCondition.setAssignTime(sdf.parse(gridListTaskCondition.getAssignTimes()));
            }
        }
        if(EMPTY.equals(gridListTaskCondition.getEndTimes())){
            if(EMPTY.equals(gridListTaskCondition.getPreEndTimes())){
                gridListTaskCondition.setEndTime(null);
            }else {
                gridListTaskCondition.setEndTime(new Date());
            }
        }else {
            if(gridListTaskCondition.getEndTimes() != null){
                gridListTaskCondition.setEndTime(sdf.parse(gridListTaskCondition.getEndTimes()));
            }
        }
        if(EMPTY.equals(gridListTaskCondition.getPreEndTimes())){
            gridListTaskCondition.setPreEndTime(null);
        }else {
            if(gridListTaskCondition.getPreEndTimes() != null){
                gridListTaskCondition.setPreEndTime(sdf.parse(gridListTaskCondition.getPreEndTimes()));
            }

        }
        return gridListTaskCondition;
    }
    /**
     *
     * 功能描述: 绩效添加参数拼装类
     *
     * @param: GridPrefCondition
     * @return: GridKpiModeEntry
     * @author: cwz
     * @date: 2018/9/30 14:07
     */
    private GridKpiModeEntry addPrefEntry(GridPrefCondition gridPrefCondition){
        GridKpiModeEntry gridKpiModeEntry = new GridKpiModeEntry();
        gridKpiModeEntry.setCleanupReward(gridPrefCondition.getCleanupReward());
        gridKpiModeEntry.setDensityRangeMax(gridPrefCondition.getDensityRangeMax());
        gridKpiModeEntry.setDensityRangeMin(gridPrefCondition.getDensityRangeMin());
        gridKpiModeEntry.setGmtCreate(new Date());
        gridKpiModeEntry.setGmtModified(new Date());
        gridKpiModeEntry.setInspectionReward(gridPrefCondition.getInspectionReward());
        gridKpiModeEntry.setMaintenanceReward(gridPrefCondition.getMaintenanceReward());
        gridKpiModeEntry.setReplaceReward(gridPrefCondition.getReplaceReward());
        gridKpiModeEntry.setReplenishmentReward(gridPrefCondition.getReplenishmentReward());
        gridKpiModeEntry.setTaskGoodReward(gridPrefCondition.getTaskGoodReward());
        return gridKpiModeEntry;
    }

    /**
     *
     * 功能描述: 绩效添加参数拼装类
     *
     * @param: GridPrefCondition
     * @return: GridKpiModeEntry
     * @author: cwz
     * @date: 2018/9/30 14:07
     */
    private GridKpiModeEntry addPrefEntry(GridPrefEditCondition gridPrefEditCondition){
        GridKpiModeEntry gridKpiModeEntry = new GridKpiModeEntry();
        gridKpiModeEntry.setId(gridPrefEditCondition.getId());
        gridKpiModeEntry.setCleanupReward(gridPrefEditCondition.getCleanupReward());
        gridKpiModeEntry.setDensityRangeMax(gridPrefEditCondition.getDensityRangeMax());
        gridKpiModeEntry.setDensityRangeMin(gridPrefEditCondition.getDensityRangeMin());
        gridKpiModeEntry.setGmtModified(new Date());
        gridKpiModeEntry.setInspectionReward(gridPrefEditCondition.getInspectionReward());
        gridKpiModeEntry.setMaintenanceReward(gridPrefEditCondition.getMaintenanceReward());
        gridKpiModeEntry.setReplaceReward(gridPrefEditCondition.getReplaceReward());
        gridKpiModeEntry.setReplenishmentReward(gridPrefEditCondition.getReplenishmentReward());
        gridKpiModeEntry.setTaskGoodReward(gridPrefEditCondition.getTaskGoodReward());
        return gridKpiModeEntry;
    }
    GridListCondition listCondition(GridListCondition gridListCondition){
        if(EMPTY.equals(gridListCondition.getName())){
            gridListCondition.setName(null);
        }
        if(EMPTY.equals(gridListCondition.getAreas())){
            gridListCondition.setAreas(null);
        }
        if(EMPTY.equals(gridListCondition.getCity())){
            gridListCondition.setCity(null);
        }
        if(EMPTY.equals(gridListCondition.getProvince())){
            gridListCondition.setProvince(null);
        }
        if(EMPTY.equals(gridListCondition.getStatus())){
            gridListCondition.setStatus(null);
        }
        return gridListCondition;
    }
}

