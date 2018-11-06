package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Department 新零售
 * @ClassName GridIntegralCondition
 * @Description 网格公司积分管理参数类
 * @Author ---CWZ
 * @Date 2018/9/27 17:30
 * @Version 1.0
 **/
@ApiModel(value = "网格公司积分管理参数类")
public class GridIntegralCondition {


    /**网格公司名*/
    @ApiModelProperty(value = "网格公司名")
    @NotNull(message = "操作原因不能为空")
    private Long gridCompanyId;

    /**积分变化*/
    @ApiModelProperty(value = "积分变化")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "积分变化不可为空")
    private BigDecimal integral;

    /**操作类型*/
    @ApiModelProperty(value = "操作类型")
    @NotNull(message = "操作类型不能为空")
    private Integer opType;

    /**操作原因*/
    @ApiModelProperty(value = "操作原因")
    @NotNull(message = "操作原因不能为空")
    private Integer opReason;

    /**备注*/
    @ApiModelProperty(value = "备注")
    @NotBlank(message = "备注不可为空")
    @Length(max = 150,message = "备注在150字以内")
    private String remark;

    /**操作人*/
    @ApiModelProperty(value = "操作人")
    private String opName;


    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getOpReason() {
        return opReason;
    }

    public void setOpReason(Integer opReason) {
        this.opReason = opReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }
}
