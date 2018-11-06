package com.hema.newretail.backstage.model.erp;

/**
 * @Department 新零售
 * @ClassName InstoreRecordBo
 * @Description ru入库记录返回值类
 * @Author ---CWZ
 * @Date 2018/11/5 11:58
 * @Version 1.0
 **/
public class InstoreRecordBo {

    private Long id;
    /**原料名称*/
    private String ingredientName;
    /**二维码编码*/
    private String qrcodeCode;
    /**到期日期*/
    private String qualityGuaranteePeriod;
    /**状态*/
    private String status;
    /**订单编号*/
    private String orderCode;
    /**是否过期*/
    private String isPeriod;
    /**操作人*/
    private String companyInstoreUserName;
    /**入库时间*/
    private String companyInstoreTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getQrcodeCode() {
        return qrcodeCode;
    }

    public void setQrcodeCode(String qrcodeCode) {
        this.qrcodeCode = qrcodeCode;
    }

    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getIsPeriod() {
        return isPeriod;
    }

    public void setIsPeriod(String isPeriod) {
        this.isPeriod = isPeriod;
    }

    public String getCompanyInstoreUserName() {
        return companyInstoreUserName;
    }

    public void setCompanyInstoreUserName(String companyInstoreUserName) {
        this.companyInstoreUserName = companyInstoreUserName;
    }

    public String getCompanyInstoreTime() {
        return companyInstoreTime;
    }

    public void setCompanyInstoreTime(String companyInstoreTime) {
        this.companyInstoreTime = companyInstoreTime;
    }
}
