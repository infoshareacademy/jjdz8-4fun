package com.infoshare.fourfan.controller;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.service.ProductService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resources")
public class ProductController {


//    @Inject
//    private ProductServiceRest productServiceRest;

    @Inject
    private ProductService productService;

    @Inject
    private ProductDao productDao;



//    @GET
//    @Path("/products")
//    public Response getProducts() {
//        return Response.ok(productServiceRest.getProducts()).build();
//    }

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
       Product product = productService.findById(id);
        return Response.status(Response.Status.OK).entity(product).build();
    }
//
//    @PUT
//    @Path("/products/{id}")
//    public Response updateProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
//        ProductDto productDto = productServiceRest.updateProduct(id, newProductDto);
//        return Response.status(Response.Status.OK).entity(productDto).build();
//    }

//    @DELETE
//    @Path("/products/{id}")
//    public Response deleteProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
//        productServiceRest.removeProduct(id);
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }

    @DELETE
    @Path("/products/{id}")
    public Response deleteProduct(@PathParam(value = "id") Integer id, @Valid NewProductDto newProductDto) {
        productService.deleteProduct(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }



//    @GET
//    @Path("/products")
//    public List<ProductDto> getProductNames() {
//        return productServiceDb.getProducts();
//    }

//    @POST
//    @Path("/products")
//    public Response createProduct(@Valid NewProductDto newProductDto) {
//        productService.createProductRest(newProductDto);
//        return Response
//                .status(Response.Status.CREATED)
//                .build();
//    }

//    @POST
//    @Path("/products")
//    public void saveProduct(Product product) {
//        productService.saveProduct(product);
//    }

//    @GET
//    @Path("/products/{id}")
//    public Response getProducts(@PathParam(value = "id") String id) {
//        return Response.status(Response.Status.OK).entity(productServiceDb.findById(Integer.valueOf(id))).build();
//    }

//    @DELETE
//    @Path("/products/{id}")
//    public Response deleteProduct(@PathParam(value = "id") String id) {
//        Product product = productServiceDb.findById(Integer.valueOf(id));
//        productServiceDb.delete(product);
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }


}