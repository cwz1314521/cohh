package com.hema.newretail.backstage.model.index;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.index
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-21 17:18
 */
public class IndexSaveDetailParamBo {

    private Integer contentType; // 内容类别 0饮品 1卡券 2活动 3猜你喜欢 4diy
    private Integer gridNo; // 格子号

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getGridNo() {
        return gridNo;
    }

    public void setGridNo(Integer gridNo) {
        this.gridNo = gridNo;
    }
}
