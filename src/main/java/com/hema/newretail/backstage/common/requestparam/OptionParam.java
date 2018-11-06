package com.hema.newretail.backstage.common.requestparam;

import java.util.List;

/**
 * Created by jiahao on 2018-08-25
 */
public class OptionParam {

    private Boolean isFrontShow;

    private String typeName;

    private Long proType;//属性类型id

    private List<ChoiceParam> optionChoice;

    public Boolean getIsFrontShow() {
        return isFrontShow;
    }

    public void setIsFrontShow(Boolean isFrontShow) {
        this.isFrontShow = isFrontShow;
    }

    public Long getProType() {
        return proType;
    }

    public void setProType(Long proType) {
        this.proType = proType;
    }

    public Boolean getFrontShow() {
        return isFrontShow;
    }

    public void setFrontShow(Boolean frontShow) {
        isFrontShow = frontShow;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ChoiceParam> getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(List<ChoiceParam> optionChoice) {
        this.optionChoice = optionChoice;
    }
}
