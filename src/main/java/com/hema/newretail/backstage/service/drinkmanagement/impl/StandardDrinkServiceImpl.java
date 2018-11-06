package com.hema.newretail.backstage.service.drinkmanagement.impl;

import com.hema.newretail.backstage.common.requestparam.*;
import com.hema.newretail.backstage.dao.BaseMenuPropertiesEntryMapper;
import com.hema.newretail.backstage.dao.BaseTagRuleEntryMapper;
import com.hema.newretail.backstage.dao.BusiIngredientMenuMapper;
import com.hema.newretail.backstage.dao.RefMenuIngredientEntryMapper;
import com.hema.newretail.backstage.entry.BaseMenuPropertiesEntry;
import com.hema.newretail.backstage.entry.BaseTagRuleEntry;
import com.hema.newretail.backstage.entry.BusiIngredientMenuEntry;
import com.hema.newretail.backstage.entry.RefMenuIngredientEntry;
import com.hema.newretail.backstage.service.drinkmanagement.StandardDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by jiahao on 2018-08-25
 */
@Service
public class StandardDrinkServiceImpl implements StandardDrinkService {

    @Autowired
    BusiIngredientMenuMapper busiIngredientMenuEntryMapper;

    @Autowired
    RefMenuIngredientEntryMapper refMenuIngredientEntryMapper;

    @Autowired
    BaseMenuPropertiesEntryMapper baseMenuPropertiesEntryMapper;

    @Autowired
    DataSourceTransactionManager transactionManager;

    @Autowired
    BaseTagRuleEntryMapper baseTagRuleEntryMapper;

    /**
     * 查询有无添加过饮品
     *
     * @param menuName
     * @return
     */
    @Override
    public BusiIngredientMenuEntry selectStandardDrink(String menuName) {
        BusiIngredientMenuEntry busiIngredientMenuEntry = busiIngredientMenuEntryMapper.selectStandardDrink(menuName);
        return busiIngredientMenuEntry;
    }

    @Override
    public String selectStandardDrink(String menuName, Long id) {
        BusiIngredientMenuEntry busiIngredientMenuEntry = busiIngredientMenuEntryMapper.selectStandardDrink(menuName);
        Long menuEntryId = busiIngredientMenuEntry.getId();
        if (id.equals(menuEntryId) && menuName.equals(busiIngredientMenuEntry.getMenuName())) {
            return "OK";
        }
        BusiIngredientMenuEntry busiIngredientMenu = selectStandardDrink(menuName);
        if (busiIngredientMenu != null) {
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 添加与修改标准饮品
     *
     * @param menuParam
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAndUpdateStandardDrink(MenuParam menuParam) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            BusiIngredientMenuEntry busiIngredientMenuEntry = new BusiIngredientMenuEntry();
            busiIngredientMenuEntry.setMenuName(menuParam.getMenuName());
            busiIngredientMenuEntry.setPrice(menuParam.getPrice());
            busiIngredientMenuEntry.setSmallPic(menuParam.getSmallPic());
            busiIngredientMenuEntry.setMiddlePic(menuParam.getMiddlePic());
            busiIngredientMenuEntry.setBigPic(menuParam.getBigPic());
            busiIngredientMenuEntry.setAnyPic(menuParam.getAnyPic());
            busiIngredientMenuEntry.setGmtCreate(new Date());
            busiIngredientMenuEntry.setStatus(menuParam.getStatus());
            busiIngredientMenuEntry.setIsDiy(0L);
            busiIngredientMenuEntry.setRecommendOrder(menuParam.getRecommendOrder());
            busiIngredientMenuEntry.setIsRecommend(menuParam.getIsRecommend());
            busiIngredientMenuEntry.setIsDeleted(0L);
            if (StringUtils.isEmpty(menuParam.getId())) {
                busiIngredientMenuEntry.setGmtModified(new Date());
                busiIngredientMenuEntryMapper.saveStandardDrink(busiIngredientMenuEntry);
            } else {
                busiIngredientMenuEntry.setId(menuParam.getId());
                busiIngredientMenuEntry.setGmtModified(new Date());
                busiIngredientMenuEntryMapper.updateByPrimaryKeySelective(busiIngredientMenuEntry);
            }

            Long id = busiIngredientMenuEntry.getId();
            List<MaterialParam> materialParamList = menuParam.getMaterialParamList();
            RefMenuIngredientEntry refMenuIngredientEntry = null;
            if (StringUtils.isEmpty(menuParam.getId())) {
                for (MaterialParam materialParam : materialParamList) {
                    refMenuIngredientEntry = new RefMenuIngredientEntry();
                    refMenuIngredientEntry.setIngredientMenuId(id);
                    refMenuIngredientEntry.setIngredientId(materialParam.getIngredientId());
                    refMenuIngredientEntry.setNum(materialParam.getNum());
                    refMenuIngredientEntryMapper.saveMaterialList(refMenuIngredientEntry);
                }
            } else {
                refMenuIngredientEntryMapper.deleteByIngredientMenuId(menuParam.getId());
                for (MaterialParam materialParam : materialParamList) {
                    refMenuIngredientEntry = new RefMenuIngredientEntry();
                    refMenuIngredientEntry.setIngredientId(materialParam.getIngredientId());
                    refMenuIngredientEntry.setNum(materialParam.getNum());
                    refMenuIngredientEntry.setIngredientMenuId(menuParam.getId());
                    refMenuIngredientEntryMapper.saveMaterialList(refMenuIngredientEntry);
                }
            }


            List<OptionParam> optionParamList = menuParam.getOptionParamList();
            if (StringUtils.isEmpty(menuParam.getId())) {
                for (OptionParam optionParam : optionParamList) {
                    BaseMenuPropertiesEntry baseMenuPropertiesEntry = null;
                    Long proType = optionParam.getProType();
                    Boolean frontShow = optionParam.getIsFrontShow();
                    List<ChoiceParam> optionChoiceList = optionParam.getOptionChoice();
                    for (ChoiceParam optionChoice : optionChoiceList) {
                        baseMenuPropertiesEntry = new BaseMenuPropertiesEntry();
                        baseMenuPropertiesEntry.setMenuId(id);
                        baseMenuPropertiesEntry.setIsDeleted(new Byte("0"));
                        baseMenuPropertiesEntry.setProName(optionChoice.getProName());
                        baseMenuPropertiesEntry.setProType(proType);
                        baseMenuPropertiesEntry.setPrice(optionChoice.getPrice());
                        baseMenuPropertiesEntry.setNum(optionChoice.getNum());
                        baseMenuPropertiesEntry.setStatus(optionChoice.getStatus());
                        baseMenuPropertiesEntry.setGmtCreate(new Date());
                        baseMenuPropertiesEntry.setIsFrontShow(frontShow);
                        baseMenuPropertiesEntryMapper.saveMenuProperties(baseMenuPropertiesEntry);
                    }
                }
            } else {
                for (OptionParam optionParam : optionParamList) {
                    BaseMenuPropertiesEntry baseMenuPropertiesEntry = null;
                    Long proType = optionParam.getProType();
                    Boolean frontShow = optionParam.getIsFrontShow();
                    List<ChoiceParam> optionChoiceList = optionParam.getOptionChoice();
                    for (ChoiceParam optionChoice : optionChoiceList) {
                        baseMenuPropertiesEntry = new BaseMenuPropertiesEntry();
                        baseMenuPropertiesEntry.setMenuId(menuParam.getId());
                        baseMenuPropertiesEntry.setGmtModified(new Date());
                        baseMenuPropertiesEntry.setIsDeleted(new Byte("0"));
                        baseMenuPropertiesEntry.setProName(optionChoice.getProName());
                        baseMenuPropertiesEntry.setProType(proType);
                        baseMenuPropertiesEntry.setPrice(optionChoice.getPrice());
                        baseMenuPropertiesEntry.setNum(optionChoice.getNum());
                        baseMenuPropertiesEntry.setStatus(optionChoice.getStatus());
                        baseMenuPropertiesEntry.setGmtCreate(new Date());
                        baseMenuPropertiesEntry.setIsFrontShow(frontShow);
                        baseMenuPropertiesEntry.setId(optionChoice.getId());
                        baseMenuPropertiesEntryMapper.updateByPrimaryKeySelective(baseMenuPropertiesEntry);
                    }
                }
            }

            //编辑时标签的修改
            if (!StringUtils.isEmpty(menuParam.getId())) {
                BaseTagRuleEntry baseTagRuleEntry = null;
                List<TagParam> tagParamList = menuParam.getTagParamList();
                Long menuId = menuParam.getId();
                baseTagRuleEntryMapper.deleteByMenuId(menuId);
                for (TagParam tagParam : tagParamList) {
                    baseTagRuleEntry = new BaseTagRuleEntry();
                    baseTagRuleEntry.setTagId(tagParam.getTagId());
                    baseTagRuleEntry.setRuleType(true);
                    baseTagRuleEntry.setMenuId(menuId);
                    baseTagRuleEntry.setMenuName(menuParam.getMenuName());
                    baseTagRuleEntry.setNum(tagParam.getNum());
                    baseTagRuleEntryMapper.insert(baseTagRuleEntry);
                }
            }
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

}
