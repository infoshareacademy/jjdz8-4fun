package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_DefaultProductService;
import com.infoshare.fourfan.service.db_ProductService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/db_productList")
public class db_ProductListServlet extends HttpServlet {

    @Inject
    private db_DefaultProductService db_defaultProductService;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductService db_productService;

    private static final Logger logger = Logger.getLogger(db_ProductListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_productList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        db_defaultProductService.createDefaultProduct();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", db_productService.getProducts());
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
