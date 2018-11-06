package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName GridDeleteCondition
 * @Description 网格公司删除参数类
 * @Author ---CWZ
 * @Date 2018/9/27 16:09
 * @Version 1.0
 **/
@ApiModel(value = "ID")
public class GridDeleteCondition {

    @ApiModelProperty(value = "ID")
    @NotNull(message = "ID不可以为空")
    private  Long id;

    private List<String> mapGeoHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getMapGeoHash() {
        return mapGeoHash;
    }

    public void setMapGeoHash(List<String> mapGeoHash) {
        this.mapGeoHash = mapGeoHash;
    }
}
