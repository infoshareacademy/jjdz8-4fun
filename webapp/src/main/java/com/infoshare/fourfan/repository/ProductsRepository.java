package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;

import javax.ejb.Local;
import java.io.PrintWriter;
import java.util.List;

@Local
public interface ProductsRepository {

    public void printProducts(PrintWriter writer, List<Product> productList);
}
