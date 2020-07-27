package com.infoshare.fourfan.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ProductNotFoundExceptionHandler implements ExceptionMapper<ProductNotFoundException> {
    @Override
    public Response toResponse(ProductNotFoundException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}