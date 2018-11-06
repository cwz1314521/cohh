package com.hema.newretail.backstage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.agent.CountNameCondition;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.BaseIngredientBoxCondition;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.BoxGroupIngredientCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BaseBoxGroupMapper;
import com.hema.newretail.backstage.dao.BaseIngredientBoxMapper;
import com.hema.newretail.backstage.dao.BaseIngredientInfoEntryMapper;
import com.hema.newretail.backstage.dao.BaseMachineTypeMapper;
import com.hema.newretail.backstage.entry.BaseBoxGroupEntry;
import com.hema.newretail.backstage.entry.BaseIngredientBoxEntry;
import com.hema.newretail.backstage.entry.BaseMachineTypeEntry;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.IngredientCondition;
import com.hema.newretail.backstage.model.tag.BaseIngredientBoxInfoBo;
import com.hema.newretail.backstage.service.IBatchingTypeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 程文政
 * @Date: 2018/8/24 18:02
 * @Description: 配料类型接口实现类
 * @Version: 1.0
 */
@Service
public class BatchingTypeManagementServiceImpl  implements IBatchingTypeManagementService {


    //注入mapper接口

    @Autowired
    private BaseBoxGroupMapper baseBoxGroupMapper;

    @Autowired
    private BaseIngredientBoxMapper baseIngredientBoxMapper;

    @Autowired
    private BaseIngredientInfoEntryMapper baseIngredientInfoEntryMapper;

    @Autowired
    private BaseMachineTypeMapper baseMachineTypeMapper;


    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);

    //查询配料组合列表接口
    @Override
    public Response mixList(IngredientCondition ingredientCondition) {
        logger.info("开始查询配料组合......");
        Page<BaseBoxGroupEntry> page =PageHelper.startPage(ingredientCondition.getPageNum(),ingredientCondition.getPageSize());
        baseBoxGroupMapper.selectByMachineTypeId(ingredientCondition);
        return Response.success(page.getResult(),page.getTotal(),ingredientCondition.getPageSize(),ingredientCondition.getPageNum());
    }

    //删除配料组合列表接口
    @Override
    public Response mixDelete(Long id) {
        int i = baseBoxGroupMapper.deleteByPrimaryKey(id);
        if(i>0){
            logger.info("删除id为"+id+"的数据......");
            return  Response.success();
        }
        return  Response.failure("删除失败");
    }


    //添加/修改料盒分配接口
    @Override
    @Transactional
    public Response binAllocationEditAdd(BoxGroupIngredientCondition boxGroupIngredientCondition) {
        logger.info("参数处理......");
        List<BaseIngredientBoxEntry> list = new ArrayList<>();
        for (BaseIngredientBoxCondition b:boxGroupIngredientCondition.getList()
             ) {
            logger.info("转化字符串为数组......");
            List<String> result = Arrays.asList(b.getBoxCodes().split(","));
            if(result.size()>=1){
                logger.info("拼装二级参数......");
                for (String boxCode:result
                     ) {
                    list.add(binAllocationEditAddCondition(boxCode,b));
                }
            }
        }
        logger.info("根据id是否存在判断......");
        if(boxGroupIngredientCondition.getId() == null){
            logger.info("添加操作......");
            BaseBoxGroupEntry baseBoxGroupEntry = new BaseBoxGroupEntry();
            logger.info("判断配料名是否存在......");
            if(baseBoxGroupMapper.selectByName(boxGroupIngredientCondition.getName()).size() > 0){
                return Response.failure("配料类型名称不可重复");
            }
            baseBoxGroupEntry.setName(boxGroupIngredientCondition.getName());
            baseBoxGroupEntry.setDesc(boxGroupIngredientCondition.getDesc());
            baseBoxGroupEntry.setGmtCreate(new Date());
            baseBoxGroupEntry.setGmtModified(new Date());
            baseBoxGroupEntry.setIsDeleted(false);
            baseBoxGroupEntry.setMachineTypeId(boxGroupIngredientCondition.getMachineTypeId());
            baseBoxGroupMapper.insert(baseBoxGroupEntry);
            baseIngredientBoxMapper.deleteByGroupId(baseBoxGroupEntry.getId());
            logger.info("轮存次表......");
            for (BaseIngredientBoxEntry baseIngredientBoxEntry:list
                 ) {
                baseIngredientBoxEntry.setBoxGroupId(baseBoxGroupEntry.getId());
                baseIngredientBoxMapper.insert(baseIngredientBoxEntry);
            }
        }else {
            logger.info("修改操作......");
            BaseBoxGroupEntry baseBoxGroupEntry = new BaseBoxGroupEntry();
            CountNameCondition countNameCondition = new CountNameCondition();
            countNameCondition.setId(boxGroupIngredientCondition.getId());
            countNameCondition.setName(boxGroupIngredientCondition.getName());
            if(baseBoxGroupMapper.selectCountByNameThisId(countNameCondition) > 0){
                return Response.failure("配料类型名称不可重复");
            }
            baseBoxGroupEntry.setId(boxGroupIngredientCondition.getId());
            baseBoxGroupEntry.setName(boxGroupIngredientCondition.getName());
            baseBoxGroupEntry.setDesc(boxGroupIngredientCondition.getDesc());
            baseBoxGroupEntry.setGmtModified(new Date());
            baseBoxGroupEntry.setIsDeleted(boxGroupIngredientCondition.getDeleted());
            baseBoxGroupEntry.setMachineTypeId(baseBoxGroupEntry.getMachineTypeId());
            baseBoxGroupMapper.updateByPrimaryKeySelective(baseBoxGroupEntry);
            baseIngredientBoxMapper.deleteByGroupId(boxGroupIngredientCondition.getId());
            logger.info("轮存次表......");
            for (BaseIngredientBoxEntry baseIngredientBoxEntry:list
                    ) {
                baseIngredientBoxEntry.setBoxGroupId(baseBoxGroupEntry.getId());
                baseIngredientBoxMapper.insert(baseIngredientBoxEntry);
            }
        }
        logger.info("操作完成......");
        return Response.success();
    }

    //查询所有配料信息接口
    @Override
    public Response ingredientInfo(Long boxGroupId) {
        List<BaseIngredientBoxInfoBo> baseIngredientBoxEntries =baseIngredientBoxMapper.selectBoxOrInfoByBoxGroupId(boxGroupId);
        return Response.success(baseIngredientBoxEntries);
    }




    //查询料盒分配接口
    @Override
    public Response binAllocationList() {
        List<BaseMachineTypeEntry>  baseMachineTypeEntry = baseMachineTypeMapper.selectAll();
        return Response.success(baseMachineTypeEntry);
    }

    @Override
    public Response allIngredients() {
        return Response.success(baseIngredientInfoEntryMapper.selectAll());
    }

    /**
     * 添加/修改料盒分配接口 ------------二级参数处理
     * @param
     * @param baseIngredientBoxCondition
     * @return
     */
    private BaseIngredientBoxEntry binAllocationEditAddCondition(String boxCode , BaseIngredientBoxCondition baseIngredientBoxCondition){
        BaseIngredientBoxEntry entry = new BaseIngredientBoxEntry();

        entry.setWarnPercent(baseIngredientBoxCondition.getWarnPercent());
        entry.setBoxGroupId(baseIngredientBoxCondition.getBoxGroupId());
        entry.setBoxCode(Integer.parseInt(boxCode));
        entry.setCapacity(baseIngredientBoxCondition.getCapacity());
        entry.setDuration(baseIngredientBoxCondition.getDuration());
        entry.setIngredientId(baseIngredientBoxCondition.getIngredientId());
        entry.setMaxCopies(baseIngredientBoxCondition.getMaxCopies());
        logger.info("......");
        return entry;
    }
}
