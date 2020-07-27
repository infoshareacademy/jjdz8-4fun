package com.infoshare.fourfan.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewProductDto {

    @NotNull
    @Size(min = 1, max = 15, message = "Name cannot be shorter than 1 and longer than 15")
    private String name;

    @NotNull
    @Size(min = 1, max = 15, message = "Brand's name cannot be shorter than 1 and longer than 15")
    private String brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
