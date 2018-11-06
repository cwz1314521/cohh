package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName ServiceCondition
 * @Description 服务网格参数类
 * @Author ---CWZ
 * @Date 2018/10/13 10:26
 * @Version 1.0
 **/
@ApiModel(description = "ServiceCondition")
public class ServiceCondition {

    @ApiModelProperty(value = "网格id")
    @NotNull(message = "网格id不可为空")
    private Long gridCompanyId;

    @ApiModelProperty(value = "geohash")
    private String geoHashs;


    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public String getGeoHashs() {
        return geoHashs;
    }

    public void setGeoHashs(String geoHashs) {
        this.geoHashs = geoHashs;
    }
}
