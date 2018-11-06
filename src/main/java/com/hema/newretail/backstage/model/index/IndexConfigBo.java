package com.hema.newretail.backstage.model.index;

import com.hema.newretail.backstage.entry.IndexpageDetailEntry;

import java.util.List;

/**
 * hema-newetaril-com.hema.newretail.backstage.model
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-20 17:26
 */
public class IndexConfigBo {
    private Long cssId;
    private String cssAbstract;
    private Short cssType;
    private Integer order;
    private Long configId;

    private List<IndexpageDetailEntry> details;

    public Long getCssId() {
        return cssId;
    }

    public void setCssId(Long cssId) {
        this.cssId = cssId;
    }

    public String getCssAbstract() {
        return cssAbstract;
    }

    public void setCssAbstract(String cssAbstract) {
        this.cssAbstract = cssAbstract;
    }

    public Short getCssType() {
        return cssType;
    }

    public void setCssType(Short cssType) {
        this.cssType = cssType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<IndexpageDetailEntry> getDetails() {
        return details;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public void setDetails(List<IndexpageDetailEntry> details) {
        this.details = details;
    }
}
