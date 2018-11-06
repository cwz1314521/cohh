package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName InStoreListCondition
 * @Description 分后台 -列表
 * @Author ---CWZ
 * @Date 2018/11/2 14:16
 * @Version 1.0
 **/
@ApiModel(value = "分后台 -列表参数类",description = "分后台 -列表参数类")
public class InStoreListCondition {


        @ApiModelProperty(value = "二维码编码")
        private List<String> qrcodeCode;

        @ApiModelProperty(value = "页码")
        private Integer pageNum;

        @ApiModelProperty(value = "每页最大数")
        private Integer pageSize;

    public List<String> getQrcodeCode() {
        return qrcodeCode;
    }

    public void setQrcodeCode(List<String> qrcodeCode) {
        this.qrcodeCode = qrcodeCode;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
