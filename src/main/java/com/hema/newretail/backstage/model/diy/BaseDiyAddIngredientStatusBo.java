package com.hema.newretail.backstage.model.diy;

import java.util.Date;

public class BaseDiyAddIngredientStatusBo {
    private Long id;

    private String scope;

    private String stateDescription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}