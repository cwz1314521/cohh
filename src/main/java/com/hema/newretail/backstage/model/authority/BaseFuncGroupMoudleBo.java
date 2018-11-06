package com.hema.newretail.backstage.model.authority;


import com.hema.newretail.backstage.entry.BaseFuncGroupIsSelectEntry;

import java.util.List;

public class BaseFuncGroupMoudleBo {

    private Long postId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    private String moudleCode;

    private String moudleName;

    private List<BaseFuncGroupIsSelectEntry> list;

    public String getMoudleCode() {
        return moudleCode;
    }

    public void setMoudleCode(String moudleCode) {
        this.moudleCode = moudleCode;
    }

    public String getMoudleName() {
        return moudleName;
    }

    public void setMoudleName(String moudleName) {
        this.moudleName = moudleName;
    }

    public List<BaseFuncGroupIsSelectEntry> getList() {
        return list;
    }

    public void setList(List<BaseFuncGroupIsSelectEntry> list) {
        this.list = list;
    }
}