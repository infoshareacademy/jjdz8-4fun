package com.infoshare.fourfan.controller;

import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductService;

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
    private ProductService productService;

    @GET
    @Path("/products")
    public Response getProducts() {
        return Response.ok(productService.getProducts()).build();
    }

    @POST
    @Path("/products")
    public Response createProduct(@Valid NewProductDto newProductDto) {
        productService.saveNewProductDB(newProductDto.getName(), newProductDto.getBrand(), 0, 0, 0, 0);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }

    @GET
    @Path("/products/{id}")
    public Response getProduct(@PathParam(value = "id") Integer id) {
        ProductDto productDto = productService.getProductById(id);
        return Response.status(Response.Status.OK).entity(productDto).build();
    }

    @PUT
    @Path("/products/{id}")
    public Response updateProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
        productService.editProduct(id, newProductDto.getName(), newProductDto.getBrand(), 0, 0, 0, 0);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/products/{id}")
    public Response deleteProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
        productService.deleteProduct(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}