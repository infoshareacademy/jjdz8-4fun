package com.infoshare.fourfan.endpoint;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductServiceDb;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void saveProduct(Product product) {
        productServiceDb.saveProduct(product);
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response save(Product product)                                                            {
//        System.out.println(product);
//        return Response.ok().build();
//    }


}
