package com.infoshare.fourfan.storage;

import com.infoshare.fourfan.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class ProductsJsonStorage {

    public static final String PRODUCTS_FILE_NAME = "Products.json";

    @Inject
    private WebInfPathResolver webInfPathResolver;
    

}
