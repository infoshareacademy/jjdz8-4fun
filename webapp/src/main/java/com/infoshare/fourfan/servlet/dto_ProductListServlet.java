package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ProductServiceDb;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/productList")
public class dto_ProductListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProductServiceDb productServiceDb;

    private static final Logger logger = Logger.getLogger(ProductListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "productList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        List<ProductDto> productDtos = ClientBuilder
                .newClient()
                .target(UriBuilder.fromPath("http://127.0.0.1:8080/shoppingList/resources/products"))
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<ProductDto>>() {});

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", productDtos);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}