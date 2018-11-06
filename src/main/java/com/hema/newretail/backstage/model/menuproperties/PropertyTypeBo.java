package com.hema.newretail.backstage.model.menuproperties;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.menuproperties
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 17:37
 */
public class PropertyTypeBo {
    private Long typeId;
    private String typeName;
    private String propertiesName;
//    private List<MenuPropertisBo> proList;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }
}
