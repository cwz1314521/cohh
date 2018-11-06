package com.hema.newretail.backstage.model.index;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.model.index
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-10-25 11:58
 */
public class IndexpageDetailBo {
    private Long id;

    private Long configId;

    private String contentType;

    private Integer gridNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getGridNo() {
        return gridNo;
    }

    public void setGridNo(Integer gridNo) {
        this.gridNo = gridNo;
    }
}
