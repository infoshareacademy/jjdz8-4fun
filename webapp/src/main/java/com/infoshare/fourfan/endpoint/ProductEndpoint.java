package com.infoshare.fourfan.endpoint;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductServiceDb;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/resources")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductEndpoint {

    @Inject
    private ProductServiceDb productServiceDb;

    @GET
    @Path("/products")
    public List<ProductDto> getProductNames() {
        return productServiceDb.getProducts();
    }

    @POST
    @Path("/products")
    public void saveProduct(Product product) {
        productServiceDb.saveProduct(product);
    }

    @GET
    @Path("/products/{id}")
    public Response getProducts(@PathParam(value = "id") String id) {
        return Response.status(Response.Status.OK).entity(productServiceDb.findById(Integer.valueOf(id))).build();
    }

    @DELETE
    @Path("/products/{id}")
    public Response deleteProduct(@PathParam(value = "id") String id) {
        Product product = productServiceDb.findById(Integer.valueOf(id));
        productServiceDb.delete(product);
        return Response.status(Response.Status.NO_CONTENT).build();
    }




}
