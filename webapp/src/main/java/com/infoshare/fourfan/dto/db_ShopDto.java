package com.infoshare.fourfan.dto;

public class db_ShopDto {

    public Integer id;
    private String shop;

    public db_ShopDto(Integer id, String shop) {
        this.id = id;
        this.shop = shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

}
