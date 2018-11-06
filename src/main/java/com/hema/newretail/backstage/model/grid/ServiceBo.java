package com.hema.newretail.backstage.model.grid;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName ServiceBo
 * @Description 服务网格列表返回
 * @Author ---CWZ
 * @Date 2018/10/13 14:00
 * @Version 1.0
 **/
public class ServiceBo {

    private List<ServiceSonBo> list;

    public List<ServiceSonBo> getList() {
        return list;
    }

    public void setList(List<ServiceSonBo> list) {
        this.list = list;
    }
}
