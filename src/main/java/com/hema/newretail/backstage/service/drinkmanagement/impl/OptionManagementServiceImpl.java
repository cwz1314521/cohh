package com.hema.newretail.backstage.service.drinkmanagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hema.newretail.backstage.common.queryparam.QueryParam;
import com.hema.newretail.backstage.dao.BaseIngredientInfoEntryMapper;
import com.hema.newretail.backstage.dao.BaseMenuPropertiesEntryMapper;
import com.hema.newretail.backstage.dao.BasePropertiesTypeEntryMapper;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.entry.BasePropertiesTypeEntry;
import com.hema.newretail.backstage.service.drinkmanagement.OptionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiahao on 2018-08-23
 */
@Service
public class OptionManagementServiceImpl implements OptionManagementService {

    @Autowired
    BaseIngredientInfoEntryMapper baseIngredientInfoEntryMapper;

    @Autowired
    BaseMenuPropertiesEntryMapper baseMenuPropertiesEntryMapper;

    @Autowired
    BasePropertiesTypeEntryMapper basePropertiesTypeEntryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertAndUpdateOption(Long id, String typeName, Long ingredientId, String propertiesName, boolean status) {

        BasePropertiesTypeEntry basePropertiesTypeEntry = new BasePropertiesTypeEntry();
        basePropertiesTypeEntry.setTypeName(typeName);
        basePropertiesTypeEntry.setIngredientId(ingredientId);
        basePropertiesTypeEntry.setPropertiesName(propertiesName);
        basePropertiesTypeEntry.setStatus(status);

        if (id != null) {
            basePropertiesTypeEntry.setId(id);
            basePropertiesTypeEntry.setGmtModified(new Date());
        } else {
            basePropertiesTypeEntry.setGmtCreate(new Date());
            basePropertiesTypeEntry.setGmtModified(new Date());
        }
        try {
            Map<String, Object> map = new HashMap(2);
            map.put("id", id);
            map.put("typeName", typeName);
            if (id != null) {
                String byTypeName = basePropertiesTypeEntryMapper.selectByTypeName(map);
                if (byTypeName == null) {
                    basePropertiesTypeEntryMapper.updatePropertiesType(basePropertiesTypeEntry);
                } else {
                    return "修改的名称重复";
                }
            } else {
                String byTypeName = basePropertiesTypeEntryMapper.selectByTypeName(map);
                if (StringUtils.isEmpty(byTypeName)) {
                    basePropertiesTypeEntryMapper.insertSelective(basePropertiesTypeEntry);
                } else {
                    return "名称重复";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "添加成功";
    }

    @Override
    public List<BaseIngredientInfoEntry> selectIngredientInfo() {
        List<BaseIngredientInfoEntry> baseIngredientInfoEntries = baseIngredientInfoEntryMapper.selectAll();
        return baseIngredientInfoEntries;
    }

    @Override
    public PageInfo<BasePropertiesTypeEntry> selectOptionList(Integer pageNum, Integer pageSize) {
        QueryParam queryParam = new QueryParam();
        if (pageNum != null && pageSize != null) {
            queryParam.setPageNum(pageNum);
            queryParam.setPageSize(pageSize);
        }

        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());

        List<BasePropertiesTypeEntry> basePropertiesTypeEntryList = basePropertiesTypeEntryMapper.selectAll();
        PageInfo<BasePropertiesTypeEntry> basePropertiesTypeEntryPageInfo = new PageInfo<>(basePropertiesTypeEntryList);
        return basePropertiesTypeEntryPageInfo;
    }
}
