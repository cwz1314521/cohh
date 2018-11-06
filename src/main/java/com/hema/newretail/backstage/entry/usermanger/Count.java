package com.hema.newretail.backstage.entry.usermanger;

/**
 * @Auther: 程文政
 * @Date: 2018/8/22 10:00
 * @Description: 各种计算结果
 * @Version: 1.0
 */
public class Count {

    private String median;//中位数

    private String chainIndex;//环比

    private String onBasis;//同比

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getChainIndex() {
        return chainIndex;
    }

    public void setChainIndex(String chainIndex) {
        this.chainIndex = chainIndex;
    }

    public String getOnBasis() {
        return onBasis;
    }

    public void setOnBasis(String onBasis) {
        this.onBasis = onBasis;
    }
}
