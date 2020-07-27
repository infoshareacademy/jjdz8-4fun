package com.infoshare.fourfan.dto;

public class db_ProductCategoryDto {

    public Integer id;
    private String category;

    public db_ProductCategoryDto(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
