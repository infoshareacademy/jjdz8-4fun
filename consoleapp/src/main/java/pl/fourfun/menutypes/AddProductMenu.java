package pl.fourfun.menutypes;

import pl.fourfun.datatypes.ProductCategory;
import pl.fourfun.datatypes.Shop;
import pl.fourfun.readwriteproducts.WriteProducts;

import java.io.IOException;
import java.util.Scanner;

public class AddProductMenu {

    String name;
    String brand;
    Integer price;
    Integer calories;
    Shop shop;
    ProductCategory productCategory;

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
    public Shop getShop() {
        return shop;
    }
    public ProductCategory getProductCategory() {
        return productCategory;
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
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void addProductMenu() throws IOException {
        boolean counter = false;

        System.out.println("===== menu dodania produktu =====");
        System.out.println("Wprowadź nazwe produktu: ");
        Scanner scannerProductName = new Scanner(System.in);
        String scannerInputProductName = scannerProductName.nextLine();
        setName(scannerInputProductName);

        while (!counter) {
            System.out.println("Wprowadź kategorie produktu: (nabiał, owoce, warzywa)");
            Scanner scannerProductCategory = new Scanner(System.in);
            String scannerInputProductCategory = scannerProductCategory.nextLine();
            switch (scannerInputProductCategory.toUpperCase()) {
                case "WARZYWA": {
                    setProductCategory(ProductCategory.WARZYWA);
                    counter = true;
                    break;
                }
                case "OWOCE": {
                    setProductCategory(ProductCategory.OWOCE);
                    counter = true;
                    break;
                }
                case "NABIAŁ": {
                    setProductCategory(ProductCategory.NABIAŁ);
                    counter = true;
                    break;
                }
                default: {
                    System.out.println("niepoprawny wybór");
                }
            }
        }

        counter = false;
        while (!counter) {
            System.out.println("Wprowadź sklep gdzie jest dostępny produkt: (Auchan, PiotriPawel, Tesco)");
            Scanner scannerProductShop = new Scanner(System.in);
            String scannerInputProductShop = scannerProductShop.nextLine();
            switch (scannerInputProductShop.toUpperCase()) {
                case "AUCHAN": {
                    setShop(Shop.AUCHAN);
                    counter = true;
                    break;
                }
                case "PIOTRiPAWEŁ": {
                    setShop(Shop.PIOTRiPAWEŁ);
                    counter = true;
                    break;
                }
                case "TESCO": {
                    setShop(Shop.TESCO);
                    counter = true;
                    break;
                }
                default: {
                    System.out.println("niepoprawny wybór");
                }
            }
        }

        System.out.println("Wprowadź producenta produktu: ");
        Scanner scannerProductBrand = new Scanner(System.in);
        String scannerInputProductBrand = scannerProductBrand.nextLine();
        setBrand(scannerInputProductBrand);

        counter = false;
        while (!counter) {
            System.out.println("Wprowadź cenę produktu: (w groszach)");
            Scanner scannerProductPrice = new Scanner(System.in);
            try {
                Integer scannerInputProductPrice = scannerProductPrice.nextInt();
                setPrice(scannerInputProductPrice);
                counter = true;
            } catch (Exception e) {
                System.out.println("niepoprawny wybór");
            }
        }

        counter = false;
        while (!counter) {
            System.out.println("Wprowadź kaloryczność produktu: ");
            Scanner scannerProductCalory = new Scanner(System.in);
            try {
                Integer scannerInputProductCalory = scannerProductCalory.nextInt();
                setCalories(scannerInputProductCalory);
                counter = true;
            } catch (Exception e) {
                System.out.println("niepoprawny wybór");
            }
        }

        System.out.println("\nPODSUMOWANIE NOWEGO PRODUKTU: ");
        System.out.println("nazwa produktu: "+ getName()+", producent: "+ getBrand()+", cena: "+ getPrice()+", kaloryczność: "+ getCalories()+", sklep: "+ getShop()+", kategoria: "+ getProductCategory() );
        WriteProducts.writingProduct(getName(),getBrand(),getPrice(),getCalories(),getShop(),getProductCategory());
        System.out.println("\n Dodano nowy produkt.");
    }
}
