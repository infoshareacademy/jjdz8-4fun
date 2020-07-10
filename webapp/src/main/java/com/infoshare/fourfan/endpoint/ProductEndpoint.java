package com.infoshare.fourfan.endpoint;

import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductServiceDb;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class ProductEndpoint {

    @Inject
    private ProductServiceDb productServiceDb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getProductNames() {
        return productServiceDb.getProducts();
    }
}
