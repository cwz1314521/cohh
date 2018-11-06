package com.hema.newretail.backstage.entry.usermanger;

import java.util.List;

/**
 * @Auther: 程文政
 * @Date: 2018/8/22 09:39
 * @Description:  年与 年份标记
 * @Version: 1.0
 */
public class Years {
    private String year;
    List<UserYears> list;

    public List<UserYears> getList() {
        return list;
    }

    public void setList(List<UserYears> list) {
        this.list = list;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
