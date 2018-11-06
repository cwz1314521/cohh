package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseMenuPropertiesEntry;
import com.hema.newretail.backstage.model.menu.MenuPropertiesBo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseMenuPropertiesEntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseMenuPropertiesEntry record);

    int insertSelective(BaseMenuPropertiesEntry record);

    BaseMenuPropertiesEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseMenuPropertiesEntry record);

    int updateByPrimaryKey(BaseMenuPropertiesEntry record);

    void saveMenuProperties(BaseMenuPropertiesEntry baseMenuPropertiesEntry);

    /**
     *
     * @param menuId
     * @return
     */
    List<MenuPropertiesBo> selectMenuProByMenuId(Long menuId);
}