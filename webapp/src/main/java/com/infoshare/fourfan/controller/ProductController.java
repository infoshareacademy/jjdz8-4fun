package com.infoshare.fourfan.controller;

import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductServiceRest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resources")
public class ProductController {


    @Inject
    private ProductServiceRest productServiceRest;

    @GET
    @Path("/products")
    public Response getProducts() {
        return Response.ok(productServiceRest.getProducts()).build();
    }

    @POST
    @Path("/products")
    public Response createProduct(@Valid NewProductDto newProductDto) {
        ProductDto productDto = productServiceRest.createProduct(newProductDto);
        return Response
                .status(Response.Status.CREATED)
                .entity(productDto)
                .build();
    }

    @GET
    @Path("/products/{id}")
    public Response getProduct(@PathParam(value = "id") Integer id) {
        ProductDto productDto = productServiceRest.getProduct(id);
        return Response.status(Response.Status.OK).entity(productDto).build();
    }

    @PUT
    @Path("/products/{id}")
    public Response updateProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
        ProductDto productDto = productServiceRest.updateProduct(id, newProductDto);
        return Response.status(Response.Status.OK).entity(productDto).build();
    }

    @DELETE
    @Path("/products/{id}")
    public Response deleteProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
        productServiceRest.removeProduct(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}