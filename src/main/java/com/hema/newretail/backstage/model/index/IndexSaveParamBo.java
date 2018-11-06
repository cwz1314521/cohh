package com.hema.newretail.backstage.model.index;

import java.util.List;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.index
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-21 17:18
 */
public class IndexSaveParamBo {

    private Long cssId; // 模板ID
    private Integer order; // 首页中模板的展示序号

    List<IndexSaveDetailParamBo> details;

    public Long getCssId() {
        return cssId;
    }

    public void setCssId(Long cssId) {
        this.cssId = cssId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<IndexSaveDetailParamBo> getDetails() {
        return details;
    }

    public void setDetails(List<IndexSaveDetailParamBo> details) {
        this.details = details;
    }
}
