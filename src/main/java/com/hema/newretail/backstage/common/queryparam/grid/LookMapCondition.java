package com.hema.newretail.backstage.common.queryparam.grid;

import org.hibernate.validator.constraints.NotBlank;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.common.queryparam.grid
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-10-17 11:36
 */
public class LookMapCondition {
    @NotBlank(message = "companyId不能为空")
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
