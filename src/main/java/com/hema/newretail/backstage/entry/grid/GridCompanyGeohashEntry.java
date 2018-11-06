package com.hema.newretail.backstage.entry.grid;

public class GridCompanyGeohashEntry {
    private Long id;

    private Long gridCompanyId;

    private String geoHashCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public String getGeoHashCode() {
        return geoHashCode;
    }

    public void setGeoHashCode(String geoHashCode) {
        this.geoHashCode = geoHashCode == null ? null : geoHashCode.trim();
    }
}