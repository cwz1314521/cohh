package com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition;

/**
 * @Auther: 程文政
 * @Date: 2018/8/25 09:08
 * @Description:
 * @Version: 1.0
 */
public class IngredientCondition {


    /**
     * 分页信息
     */

    private Integer pageSize;

    private Integer pageNum;

    //查询配料组合列表接口
    //机器类型
    private Long machineTypeId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }
}
