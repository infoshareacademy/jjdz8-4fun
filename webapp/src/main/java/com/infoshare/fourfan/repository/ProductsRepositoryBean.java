package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;

import java.io.PrintWriter;
import java.util.List;

public class ProductsRepositoryBean implements  ProductsRepository{
    @Override
    public void printProducts(PrintWriter writer, List<Product> productList) {

        for(Product product:productList){
            
        }


    }
}
