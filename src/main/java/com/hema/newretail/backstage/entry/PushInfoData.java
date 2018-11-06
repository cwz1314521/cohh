package com.hema.newretail.backstage.entry;

import java.util.Date;
import java.util.List;

/**
 * 推送信息实体类
 */
public class PushInfoData {

    private String id;//消息Id
    private String title;//标题
    private String content;//内容
    private String operator;//发送者
    private List<String> userIsRead;//是否已读 如果用户已读，就将该用户添加到集合中
    private Date pushTime;
    private List<String> userIsDel;
    private List<String> users;//接收用户
    private String province="";
    private String city="";
    private String district="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getUserIsRead() {
        return userIsRead;
    }

    public void setUserIsRead(List<String> userIsRead) {
        this.userIsRead = userIsRead;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }


    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<String> getUserIsDel() {
        return userIsDel;
    }

    public void setUserIsDel(List<String> userIsDel) {
        this.userIsDel = userIsDel;
    }
}
