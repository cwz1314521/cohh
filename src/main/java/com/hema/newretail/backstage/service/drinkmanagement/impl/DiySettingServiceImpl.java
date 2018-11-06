package com.hema.newretail.backstage.service.drinkmanagement.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.diy.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.*;
import com.hema.newretail.backstage.entry.*;
import com.hema.newretail.backstage.model.diy.*;
import com.hema.newretail.backstage.service.drinkmanagement.DiySettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName DiySettingServiceImpl
 * @Description 饮品管理----Diy配料设置  or  diy系统设置---IMPL
 * @Author ---CWZ
 * @Date 2018/10/17 16:38
 * @Version 1.0
 **/
@Service
public class DiySettingServiceImpl implements DiySettingService {


    @Autowired
    private BaseGlobalInfoMapper baseGlobalInfoMapper;

    @Autowired
    private BaseDiyAddIngredientStatusMapper baseDiyAddIngredientStatusMapper;

    @Autowired
    private BaseIngredientInfoEntryMapper baseIngredientInfoEntryMapper;

    @Autowired
    private BaseDiyIngredientEventMapper baseDiyIngredientEventMapper;

    @Autowired
    private BaseDiyIngredientSettingMapper baseDiyIngredientSettingMapper;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);

    private final static String DIYPRICE = "diy_price";
    private final static String NODATA = "暂无数据";
    private final static String INSERTDATAFAILED ="插入数据失败";
    private final static String UPDATEDATAFAILED ="更新数据失败";
    private final static String DELETEDATAFAILED ="更新数据失败";
    private final static String EMPTY="";

    /**
     * 功能描述: 前端不需要传入参数，返回diy商品折扣前价格
     *
     * @param: null
     * @return: Price diy饮品折扣前价格
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    @Override
    public Response diyPrice() {
        String key = DIYPRICE;
        logger.info("检索diy价格......");
        BaseGlobalInfoEntry baseGlobalInfoEntry = baseGlobalInfoMapper.selectByKey(key);
        if(baseGlobalInfoEntry == null){
            logger.error("检索数据为空......");
            return Response.failure(NODATA);
        }
        return Response.success(baseGlobalInfoEntry.getValue());
    }

    /**
     * 功能描述: DIY状态描述设置列表展示
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/17 17:42
     */
    @Override
    public Response diyStatusDescription() {
        logger.info("检索所有状态描述......");
        List<BaseDiyAddIngredientStatusEntry> b = baseDiyAddIngredientStatusMapper.selectAll();
        if(b == null){
            logger.error("检索数据为空......");
            return Response.failure(NODATA);
        }
        List<BaseDiyAddIngredientStatusBo> bos = new ArrayList<>();
        for (BaseDiyAddIngredientStatusEntry base:b
             ) {
            StringBuffer stringBuffer = new StringBuffer();
            logger.info("拼装返回数据......");
            stringBuffer.append(base.getIngredientsVolumeMin()).append("~").append(base.getIngredientsVolumeMax());
            BaseDiyAddIngredientStatusBo bo = new BaseDiyAddIngredientStatusBo();
            bo.setId(base.getId());
            bo.setScope(stringBuffer.toString());
            bo.setStateDescription(base.getStateDescription());
            bos.add(bo);
        }
        return Response.success(bos);
    }

    /**
     * 功能描述: DIY状态描述增加
     *
     * @param: DiyStatusAddEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 18:18
     */
    @Override
    public Response addStatusDescription(DiyStatusAddEditCondition diyStatusAddEditCondition) {
        logger.info("拼装参数......");
        BaseDiyAddIngredientStatusEntry base = new BaseDiyAddIngredientStatusEntry();
        base.setIngredientsVolumeMax(diyStatusAddEditCondition.getIngredientsVolumeMax());
        base.setIngredientsVolumeMin(diyStatusAddEditCondition.getIngredientsVolumeMin());
        base.setStateDescription(diyStatusAddEditCondition.getStateDescription());
        base.setGmtCreate(new Date());
        base.setGmtModified(new Date());
        logger.info("增加操作......");
        int insert = baseDiyAddIngredientStatusMapper.insert(base);
        if(insert == 1){
            logger.info("增加成功......");
            return Response.success();
        }else {
            logger.error("增加失败......");
            return Response.failure(INSERTDATAFAILED);
        }
    }

    /**
     * 功能描述: DIY状态描述修改
     *
     * @param: DiyStatusAddEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 18:18
     */
    @Override
    public Response editStatusDescription(DiyStatusAddEditCondition diyIdCondition) {
        logger.info("拼装参数......");
        BaseDiyAddIngredientStatusEntry base = new BaseDiyAddIngredientStatusEntry();
        base.setIngredientsVolumeMax(diyIdCondition.getIngredientsVolumeMax());
        base.setIngredientsVolumeMin(diyIdCondition.getIngredientsVolumeMin());
        base.setStateDescription(diyIdCondition.getStateDescription());
        base.setId(diyIdCondition.getId());
        base.setGmtModified(new Date());
        logger.info("更新操作......");
        int update = baseDiyAddIngredientStatusMapper.updateByPrimaryKeySelective(base);
        if(update == 1){
            logger.info("更新成功......");
            return Response.success();
        }else {
            logger.error("更新失败......");
            return Response.failure(UPDATEDATAFAILED);
        }
    }

    /**
     * 功能描述: DIY状态描述删除
     *
     * @param idCondition
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 9:57
     */
    @Override
    public Response deleteStatusDescription(IdCondition idCondition) {
        logger.info("删除id为"+idCondition.getId()+"的数据......");
        int base = baseDiyAddIngredientStatusMapper.deleteByPrimaryKey(idCondition.getId());
        if(base == 1){
            logger.info("删除成功......");
            return Response.success();
        }else {
            logger.error("删除失败......");
            return Response.failure(DELETEDATAFAILED);
        }
    }

    /**
     * 功能描述: 配料选择---辅助接口
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:30
     */
    @Override
    public Response allIngredient() {
        logger.info("检索数据......");
        List<BaseIngredientInfoEntry> list = baseIngredientInfoEntryMapper.selectAll();
        if(list == null){
            logger.error("检索数据为空......");
            return Response.failure(NODATA);
        }
        List<IngredientBo> bos = new ArrayList<>();
        for (BaseIngredientInfoEntry base:list
             ) {
            logger.info("轮存数据......");
            IngredientBo bo = new IngredientBo();
            bo.setId(base.getId());
            bo.setIngredientName(base.getIngredientName());
            bos.add(bo);
        }
        return Response.success(bos);
    }

    /**
     * 功能描述: 事件列表
     *
     * @param nameCondition
     * @param: null or NameCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:30
     */
    @Override
    public Response listEvent(NameCondition nameCondition) {
        logger.info("检索数据......");
        Page<IngredientEventBo> page =PageHelper.startPage(nameCondition.getPageNum(),nameCondition.getPageSize());
        List<IngredientEventBo> list = baseDiyIngredientSettingMapper.selectAllEvent(nameCondition);
        if(list == null){
            logger.error("检索数据为空......");
            return Response.failure(NODATA);
        }else {
            logger.info("查询完成......");
            return Response.success(page.getResult(),page.getTotal(),nameCondition.getPageSize(),nameCondition.getPageNum());
        }
    }

    /**
     * 功能描述:
     *
     * @param idCondition
     * @param: IdCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    @Override
    public Response detailEvent(IdCondition idCondition) {
        logger.info("检索详情......");
        DetailEventBo detailEventBo = baseDiyIngredientSettingMapper.selectDetail(idCondition.getId());
        if(detailEventBo == null){
            logger.error("检索详情为空......");
           return Response.failure(NODATA);
        }else {
            logger.info("检索详情完成......");
            return Response.success(detailEventBo);
        }
    }

    /**
     * 功能描述:配料事件---编辑添加
     *
     * @param addEditEventCondition
     * @param: AddEditEventCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    @Override
    @Transactional
    public Response addEditEvent(AddEditEventCondition addEditEventCondition) {

        if(EMPTY.equals(addEditEventCondition.getId())){
            logger.info("判断id是否为空串......转化为null");
            addEditEventCondition.setId(null);
        }
        logger.info("判断是新增还是修改......");
        if (addEditEventCondition.getId() != null) {
            /*改*/
            BaseDiyIngredientSettingEntry baseDiyIngredientSettingEntry = new BaseDiyIngredientSettingEntry();
            baseDiyIngredientSettingEntry.setId(addEditEventCondition.getId());
            baseDiyIngredientSettingEntry.setMaxIngredient(addEditEventCondition.getMaxIngredient());
            baseDiyIngredientSettingEntry.setMaxTime(addEditEventCondition.getMaxTime());
            baseDiyIngredientSettingEntry.setMarkedWords(addEditEventCondition.getMarkedWords());
            baseDiyIngredientSettingEntry.setGmtModified(new Date());
            logger.info("存储主表......");
            baseDiyIngredientSettingMapper.updateByPrimaryKeySelective(baseDiyIngredientSettingEntry);
            logger.info("清除事件表脏数据......");
            baseDiyIngredientEventMapper.deleteBySettingId(addEditEventCondition.getId());
            for (DetailEventSonBo detail : addEditEventCondition.getList()
                    ) {
                BaseDiyIngredientEventEntry base = new BaseDiyIngredientEventEntry();
                if(detail.getIngredientId()==null){
                    logger.error("IngredientId为空......");
                    return Response.failure("IngredientId不能为空");
                }
                base.setDiySettingId(addEditEventCondition.getId());
                base.setMarkedWords(detail.getMarkedWords());
                base.setIngredientId(detail.getIngredientId());
                logger.info("轮存事件表......");
                baseDiyIngredientEventMapper.insert(base);
            }
            return Response.success();
        } else {
            BaseDiyIngredientSettingEntry baseDiyIngredientSettingEntry = new BaseDiyIngredientSettingEntry();
            baseDiyIngredientSettingEntry.setIngredientId(addEditEventCondition.getIngredientId());
            baseDiyIngredientSettingEntry.setMaxIngredient(addEditEventCondition.getMaxIngredient());
            baseDiyIngredientSettingEntry.setMaxTime(addEditEventCondition.getMaxTime());
            baseDiyIngredientSettingEntry.setMarkedWords(addEditEventCondition.getMarkedWords());
            baseDiyIngredientSettingEntry.setGmtCreate(new Date());
            baseDiyIngredientSettingEntry.setGmtModified(new Date());
            logger.info("存储主表......");
            baseDiyIngredientSettingMapper.insert(baseDiyIngredientSettingEntry);
            logger.info("清除事件表脏数据......");
            baseDiyIngredientEventMapper.deleteBySettingId(baseDiyIngredientSettingEntry.getId());
            for (DetailEventSonBo detail : addEditEventCondition.getList()
                    ) {
                BaseDiyIngredientEventEntry base = new BaseDiyIngredientEventEntry();
                if(detail.getIngredientId()==null){
                    logger.error("IngredientId为空......");
                    return Response.failure("IngredientId不能为空");
                }
                base.setDiySettingId(baseDiyIngredientSettingEntry.getId());
                base.setIngredientId(detail.getIngredientId());
                base.setMarkedWords(detail.getMarkedWords());
                logger.info("轮存事件表......");
                baseDiyIngredientEventMapper.insert(base);
            }
            return Response.success();
        }
    }

    /**
     * 功能描述: 配料事件---删除
     *
     * @param idCondition
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 14:52
     */
    @Override
    @Transactional
    public Response deleteEvent(IdCondition idCondition) {
        logger.info("删除主表数据......");
        baseDiyIngredientSettingMapper.deleteByPrimaryKey(idCondition.getId());
        logger.info("删除事件表数据......");
        baseDiyIngredientEventMapper.deleteBySettingId(idCondition.getId());
        return Response.success();
    }

    /**
     * 功能描述: 传入参数，修改diy商品折扣前价格
     *
     * @param priceCondition
     * @param: string
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    @Override
    public Response editPrice(PriceCondition priceCondition) {
        logger.info("检索价格数据并拼装......");
        BaseGlobalInfoEntry baseGlobalInfoEntry = baseGlobalInfoMapper.selectByKey(DIYPRICE);
        baseGlobalInfoEntry.setValue(priceCondition.getPrice());
        logger.info("更新价格操作......");
        baseGlobalInfoMapper.updateByPrimaryKey(baseGlobalInfoEntry);
        return Response.success();
    }
}
