package com.hema.newretail.backstage.common.queryparam;


public class QueryParam {

    protected Integer pageNum;
    protected Integer pageSize;
    protected String column;
    protected String orderType;

    public Integer getPageNum() {
        return pageNum != null && pageNum != 0 ? pageNum : 1;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return pageSize != null && pageSize != 0 ? pageSize : 10;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10; // 默认10条
        } else {
            this.pageSize = pageSize;
        }
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
