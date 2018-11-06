package com.hema.newretail.backstage.entry;

public class BaseCompanyGeoHashData {
    private Long id;

    private Long companyId;

    private String geoHashCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getGeoHashCode() {
        return geoHashCode;
    }

    public void setGeoHashCode(String geoHashCode) {
        this.geoHashCode = geoHashCode == null ? null : geoHashCode.trim();
    }
}