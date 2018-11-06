package com.hema.newretail.backstage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.authority.TagCondition;
import com.hema.newretail.backstage.common.queryparam.tag.TagCountTagNameCondition;
import com.hema.newretail.backstage.common.utils.RedisUtils;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BaseTagEntryMapper;
import com.hema.newretail.backstage.dao.BaseTagRuleEntryMapper;
import com.hema.newretail.backstage.dao.BusiIngredientMenuMapper;
import com.hema.newretail.backstage.entry.BaseTagEntry;
import com.hema.newretail.backstage.entry.BaseTagRuleEntry;
import com.hema.newretail.backstage.entry.BusiIngredientMenuEntry;
import com.hema.newretail.backstage.model.tag.BaseTagEditBo;
import com.hema.newretail.backstage.model.tag.BaseTagRuleEditBo;
import com.hema.newretail.backstage.model.tag.BaseTagRuleJointBo;
import com.hema.newretail.backstage.service.ITagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 程文政
 * @Date: 2018/8/20 13:09
 * @Description:
 * @Version: 1.0
 */
@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private BaseTagRuleEntryMapper baseTagRuleEntryMapper;

    @Autowired
    private BaseTagEntryMapper baseTagEntryMapper;

    @Autowired
    private BusiIngredientMenuMapper busiIngredientMenuEntryMapper;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);

    /**查询所有饮品*/
    @Override
    public Response queryAllDrink(Integer pageNum, Integer pageSize) {
        logger.info("查询所有饮品...");
        Page<BusiIngredientMenuEntry> page =PageHelper.startPage(pageNum,pageSize);
        busiIngredientMenuEntryMapper.selectAll();
        logger.info("查询所有饮品完毕");
        return Response.success(page.getResult(),page.getTotal(),pageSize,pageNum);
    }

    /**返回拼接字符串标签首页*/
    @Override
    public Response tagJoint(Integer pageNum, Integer pageSize) {
        logger.info("分页插件进行分页处理.....");
        Page<BaseTagEntry> page =PageHelper.startPage(pageNum,pageSize);
        baseTagEntryMapper.selectNotDelete();
        List<BaseTagEntry> baseTagEntries = page.getResult();
        List<BaseTagRuleJointBo> baseTagRuleBos = new ArrayList<>();
        logger.info("循环存储标签数据......");
        for (BaseTagEntry baseTagEntry:baseTagEntries
                ) {
            BaseTagRuleJointBo baseTagRuleBo = new BaseTagRuleJointBo();
            List<BaseTagRuleEntry> baseTagRuleEntries= baseTagRuleEntryMapper.selectByTId(baseTagEntry.getId());
            StringBuilder tagJoint= new StringBuilder();
            logger.info("循环拼装规则数据");
            for (BaseTagRuleEntry baseTagRuleEntry:baseTagRuleEntries
                    ) {
                logger.info("拼装....");
                tagJoint.append("购买").append(baseTagRuleEntry.getMenuName()).append("超过").
                        append(baseTagRuleEntry.getNum().toString()).append("杯,");
            }
            if(tagJoint.length()>5){
                logger.info("判断是否拼装过一次，去掉最后的逗号.....");
                tagJoint.substring(0,tagJoint.length()-1);
            }
            baseTagRuleBo.setId(baseTagEntry.getId());
            baseTagRuleBo.setTagname(baseTagEntry.getTagname());
            baseTagRuleBo.setTagJoint(tagJoint.toString());
            baseTagRuleBos.add(baseTagRuleBo);
        }
        logger.info("拼装完成......"+baseTagRuleBos.toString());
        return Response.success(baseTagRuleBos,page.getTotal(),page.getPageSize(),page.getPageNum());

    }

    /**标签增*/
    @Override
    @Transactional
    public Response tagAdd(BaseTagEditBo baseTagEditBo) {
        if(baseTagEntryMapper.selectCountByTName(baseTagEditBo.getTagName())>0){
            logger.info("标签名重复...");
            return Response.failure("标签名重复");
        }
        //标签表存储
        BaseTagEntry baseTagEntry = new BaseTagEntry();
        baseTagEntry.setIsDeleted(false);
        baseTagEntry.setTagname(baseTagEditBo.getTagName());
        logger.info("存储标签表...");
        baseTagEntryMapper.insert(baseTagEntry);
        logger.info("清除可能存在的规则表脏数据...");
        baseTagRuleEntryMapper.deleteByTId(baseTagEntry.getId());
        for (BaseTagRuleEditBo bo:baseTagEditBo.getTagRules()
             ) {
            BaseTagRuleEntry baseTagRuleEntry = new BaseTagRuleEntry();
            baseTagRuleEntry.setMenuId(bo.getMenuId());
            baseTagRuleEntry.setMenuName(bo.getMenuName());
            baseTagRuleEntry.setTagId(baseTagEntry.getId());
            baseTagRuleEntry.setRuleType(bo.getRuleType());
            baseTagRuleEntry.setNum(bo.getNum());
            TagCondition a = new TagCondition();
            a.setMenuName(bo.getMenuName());
            a.setTagId(baseTagEntry.getId());
            logger.info("判断是否存入相同饮品名数据...");
            int ss = baseTagRuleEntryMapper.selectByMenuNameCount(a);
            if(ss>0){
                logger.info("存入相同饮品名数据...返回重复提示");
                return Response.failure("饮品名不可重复");
            }
            logger.info("循环存储...");
            baseTagRuleEntryMapper.insert(baseTagRuleEntry);
        }
        logger.info("存储标签成功...");
        return  Response.success();
    }
    /**查询单个数据--修改详情页*/
    @Override
    public BaseTagEditBo queryOneTag(Long tagId) {
        logger.info("根据tagId分别查询标签表和规则表...");
        BaseTagEntry baseTagEntry =  baseTagEntryMapper.selectByPrimaryKey(tagId);
        List<BaseTagRuleEntry> baseTagRuleEntries = baseTagRuleEntryMapper.selectByTId(tagId);
        logger.info("拼装标签详情model...");
        BaseTagEditBo baseTagEditBo = new BaseTagEditBo();
        List<BaseTagRuleEditBo> baseTagRuleEditBos = new ArrayList<>();
        logger.info("判断规则表是否有数据...");
        if(baseTagRuleEntries != null) {
            for (BaseTagRuleEntry enry : baseTagRuleEntries
                    ) {
                BaseTagRuleEditBo bo = new BaseTagRuleEditBo();
                logger.info("轮存规则表数据...");
                bo.setMenuId(enry.getMenuId());
                bo.setMenuName(enry.getMenuName());
                bo.setNum(enry.getNum());
                bo.setRuleType(enry.getRuleType());
                baseTagRuleEditBos.add(bo);
            }
        }
        baseTagEditBo.setTagId(baseTagEntry.getId());
        baseTagEditBo.setTagName(baseTagEntry.getTagname());
        baseTagEditBo.setTagRules(baseTagRuleEditBos);
        logger.info("标签详情拼装完成");
        return baseTagEditBo;
    }
    /**标签改*/
    @Override
    @Transactional
    public Response tagEdit(BaseTagEditBo baseTagEditBo) {
        //标签表修改
        TagCountTagNameCondition tagCountTagNameCondition = new TagCountTagNameCondition();
        tagCountTagNameCondition.setId(baseTagEditBo.getTagId());
        tagCountTagNameCondition.setTagname(baseTagEditBo.getTagName());
        if(baseTagEntryMapper.selectCountByTNameNotThisId(tagCountTagNameCondition) > 0){
            logger.info("标签名重复...");
            return Response.failure("标签名重复");
        }
        BaseTagEntry baseTagEntry = new BaseTagEntry();
        baseTagEntry.setId(baseTagEditBo.getTagId());
        baseTagEntry.setIsDeleted(false);
        baseTagEntry.setTagname(baseTagEditBo.getTagName());
        baseTagEntryMapper.updateByPrimaryKey(baseTagEntry);
        logger.info("清除可能存在的规则表脏数据...");
        baseTagRuleEntryMapper.deleteByTId(baseTagEditBo.getTagId());
        for (BaseTagRuleEditBo bo:baseTagEditBo.getTagRules()
                ) {
            BaseTagRuleEntry baseTagRuleEntry = new BaseTagRuleEntry();
            baseTagRuleEntry.setMenuName(bo.getMenuName());
            baseTagRuleEntry.setMenuId(bo.getMenuId());
            baseTagRuleEntry.setTagId(baseTagEntry.getId());
            baseTagRuleEntry.setRuleType(bo.getRuleType());
            baseTagRuleEntry.setNum(bo.getNum());
            TagCondition a = new TagCondition();
            a.setMenuName(bo.getMenuName());
            a.setTagId(baseTagEntry.getId());
            logger.info("判断是否存入相同饮品名数据...");
            int ss = baseTagRuleEntryMapper.selectByMenuNameCount(a);
            if(ss>0){
                logger.info("存入相同饮品名数据...返回重复提示");
                return Response.failure("饮品名不可重复");
            }
            logger.info("循环存储...");
            baseTagRuleEntryMapper.insert(baseTagRuleEntry);
        }
        logger.info("修改标签成功...");
        return  Response.success();
    }
    /**标签删除*/
    /**逻辑删除*/
    @Override
    public Response tagDelete(Long tagId) {
        BaseTagEntry baseTagEntry =  new BaseTagEntry();
        baseTagEntry.setIsDeleted(true);
        baseTagEntry.setId(tagId);
        logger.info("逻辑删除Id为"+tagId+"的标签数据");
        int a = baseTagEntryMapper.updateByPrimaryKeySelective(baseTagEntry);
        if(a<1){
            return Response.failure("操作失败");
        }else {
            return Response.success();
        }
    }
}
