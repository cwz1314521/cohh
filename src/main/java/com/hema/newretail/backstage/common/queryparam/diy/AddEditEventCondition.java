package com.hema.newretail.backstage.common.queryparam.diy;

import com.hema.newretail.backstage.model.diy.DetailEventSonBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName DetailEventBo
 * @Description 增加修改参数类
 * @Author ---CWZ
 * @Date 2018/10/18 12:52
 * @Version 1.0
 **/
@ApiModel(description = "AddEditEventCondition")
public class AddEditEventCondition {

    @ApiModelProperty(value = "主键")
    private Long id ;

    @ApiModelProperty(value = "最大毫升数")
    @NotNull(message = "最大毫升数不能为空")
    private BigDecimal maxIngredient;

    @NotNull(message = "最大时间不能为空")
    @ApiModelProperty(value = "最大时间")
    private Integer maxTime;

    @ApiModelProperty(value = "次表")
    private List<DetailEventSonBo> list;

    @NotBlank(message = "提示语不能为空")
    @ApiModelProperty(value = "提示语")
    private String markedWords;

    @NotNull(message = "配料id不能为空")
    @ApiModelProperty(value = "配料id")
    private Long ingredientId;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMaxIngredient() {
        return maxIngredient;
    }

    public void setMaxIngredient(BigDecimal maxIngredient) {
        this.maxIngredient = maxIngredient;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public List<DetailEventSonBo> getList() {
        return list;
    }

    public void setList(List<DetailEventSonBo> list) {
        this.list = list;
    }

    public String getMarkedWords() {
        return markedWords;
    }

    public void setMarkedWords(String markedWords) {
        this.markedWords = markedWords;
    }
}
