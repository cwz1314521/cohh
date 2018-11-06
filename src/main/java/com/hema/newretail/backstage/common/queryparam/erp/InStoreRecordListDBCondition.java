package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Department 新零售
 * @ClassName InStoreRecordListCondition
 * @Description 分后台---入库记录--列表
 * @Author ---CWZ
 * @Date 2018/11/3 11:58
 * @Version 1.0
 **/
@ApiModel(value = "分后台---入库记录--列表",description = "分后台---入库记录--列表")
public class InStoreRecordListDBCondition {


    @ApiModelProperty(value = "二维码编码")
    private String qrcodeCode;

    @ApiModelProperty(value = "配料名称")
    private Long ingredientId;


    @ApiModelProperty(value = "订单编码")
    private String orderCode;

    @ApiModelProperty(value = "过期时间")
    private Date qualityGuaranteePeriod;


    @ApiModelProperty(value = "是否过期 0不过期 1过期")
    private Integer isPeriod;



    @ApiModelProperty(value = "目前状态 0待入库 1已入库")
    private Integer status;

    @ApiModelProperty(value = "入库时间-开始时间")
    private Date startDate;

    @ApiModelProperty(value = "入库时间-结束时间")
    private Date endDate;

    @ApiModelProperty(value = "分公司入库人")
    private Long  companyInstoreId;

    public String getQrcodeCode() {
        return qrcodeCode;
    }

    public void setQrcodeCode(String qrcodeCode) {
        this.qrcodeCode = qrcodeCode;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(Date qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public Integer getIsPeriod() {
        return isPeriod;
    }

    public void setIsPeriod(Integer isPeriod) {
        this.isPeriod = isPeriod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getCompanyInstoreId() {
        return companyInstoreId;
    }

    public void setCompanyInstoreId(Long companyInstoreId) {
        this.companyInstoreId = companyInstoreId;
    }

}
