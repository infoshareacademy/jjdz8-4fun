package com.infoshare.fourfan.storage;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;

public class ProductDb {

    private static ProductList productList = new ProductList();

    public static ProductList getRepository() {
        if (productList.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return productList;
    }

    private static void fillRepositoryWithDefaults() {

        Product product1 = new Product();
        product1.setName("Pomarańcz");
        product1.setBrand("Java");
        product1.setPrice(250);
        product1.setCalories(220);
        product1.setShop(Shop.TESCO);
        product1.setProductCategory(ProductCategory.OWOCE);
        productList.add(product1);

        Product product2 = new Product();
        product2.setName("Jogurt");
        product2.setBrand("Danone");
        product2.setPrice(450);
        product2.setCalories(100);
        product2.setShop(Shop.AUCHAN);
        product2.setProductCategory(ProductCategory.NABIAŁ);
        productList.add(product2);

        Product product3 = new Product();
        product3.setName("Sałata siewna");
        product3.setBrand("No brand");
        product3.setPrice(400);
        product3.setCalories(50);
        product3.setShop(Shop.TESCO);
        product3.setProductCategory(ProductCategory.WARZYWA);
        productList.add(product3);

        Product product4 = new Product();
        product4.setName("Kalafior");
        product4.setBrand("Hortex");
        product4.setPrice(123);
        product4.setCalories(160);
        product4.setShop(Shop.PIOTRiPAWEŁ);
        product4.setProductCategory(ProductCategory.WARZYWA);
        productList.add(product4);

        Product product5 = new Product();
        product5.setName("Pierogi");
        product5.setBrand("Iglo");
        product5.setPrice(400);
        product5.setCalories(230);
        product5.setShop(Shop.PIOTRiPAWEŁ);
        product5.setProductCategory(ProductCategory.NABIAŁ);
        productList.add(product5);

        Product product6 = new Product();
        product6.setName("Kiwi");
        product6.setBrand("Alpaka");
        product6.setPrice(250);
        product6.setCalories(300);
        product6.setShop(Shop.TESCO);
        product6.setProductCategory(ProductCategory.OWOCE);
        productList.add(product6);
    }

    public static boolean contains(Product product) {
        ProductList repository = getRepository();
        for (Product productFromList : repository.getProductList()) {
            if (productFromList.getName() == product.getName()) {
                return true;
            }
        }
        return false;
    }
}