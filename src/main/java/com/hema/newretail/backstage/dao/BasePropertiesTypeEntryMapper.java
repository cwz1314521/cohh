package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BasePropertiesTypeEntry;
import com.hema.newretail.backstage.model.menuproperties.PropertyTypeBo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BasePropertiesTypeEntryMapper {
    int insert(BasePropertiesTypeEntry record);

    int insertSelective(BasePropertiesTypeEntry record);

    void deletePropertiesType(Long id);

    void updatePropertiesType(BasePropertiesTypeEntry record);

    String selectByTypeName(Map<String, Object> map);

    BasePropertiesTypeEntry selectByTypeNameObject(String typeName);

    List<BasePropertiesTypeEntry> selectAll();

    /**
     *
     * @return
     */
    List<PropertyTypeBo> selectAllType();
}