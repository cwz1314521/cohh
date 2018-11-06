package com.hema.newretail.backstage.entry.erp;

public class ErpContractPicEntry {
    private Long id;

    private Long ingredientManufacturerId;

    private String contractPics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredientManufacturerId() {
        return ingredientManufacturerId;
    }

    public void setIngredientManufacturerId(Long ingredientManufacturerId) {
        this.ingredientManufacturerId = ingredientManufacturerId;
    }

    public String getContractPics() {
        return contractPics;
    }

    public void setContractPics(String contractPics) {
        this.contractPics = contractPics;
    }

    @Override
    public String toString() {
        return "ErpContractPicEntry{" +
                "id=" + id +
                ", ingredientManufacturerId=" + ingredientManufacturerId +
                ", contractPics='" + contractPics + '\'' +
                '}';
    }
}