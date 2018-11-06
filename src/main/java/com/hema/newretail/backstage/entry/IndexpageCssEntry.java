package com.hema.newretail.backstage.entry;

public class IndexpageCssEntry {
    private Long id;

    private String cssContent;

    private Short cssType;

    private String cssAbstract;

    private Integer gruidNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCssContent() {
        return cssContent;
    }

    public void setCssContent(String cssContent) {
        this.cssContent = cssContent == null ? null : cssContent.trim();
    }

    public Short getCssType() {
        return cssType;
    }

    public void setCssType(Short cssType) {
        this.cssType = cssType;
    }

    public String getCssAbstract() {
        return cssAbstract;
    }

    public void setCssAbstract(String cssAbstract) {
        this.cssAbstract = cssAbstract == null ? null : cssAbstract.trim();
    }

    public Integer getGruidNum() {
        return gruidNum;
    }

    public void setGruidNum(Integer gruidNum) {
        this.gruidNum = gruidNum;
    }
}