package pl.fourfun;

public class Product {
    String name;
    String brand;
    //Cena w reprezentowana w groszach
    Integer price;
    Integer calories;

    public Product(String name, String brand, Integer price, Integer calories) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
