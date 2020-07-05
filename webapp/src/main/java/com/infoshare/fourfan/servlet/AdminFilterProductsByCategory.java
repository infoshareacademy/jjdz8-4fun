package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ProductService;
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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/admin-filter-products-by-category")
public class AdminFilterProductsByCategory extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminFilterProductsByCategory.class.getName());

    @Inject
    private ProductService productService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String catParam = req.getParameter("category");
        PrintWriter writer = resp.getWriter();

        Template template = templateProvider.getTemplate(getServletContext(), "admin-filter-products-by-category.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("dairy", ProductCategory.NABIAŁ.ordinal());
        dataModel.put("veggies", ProductCategory.WARZYWA.ordinal());
        dataModel.put("fruits", ProductCategory.OWOCE.ordinal());

        if (catParam != null && (!catParam.equals("Wybierz")) || catParam.isBlank()) {
            Integer categoryInt = Integer.parseInt(catParam);
            List<Product> products = productService.filterByCategory(categoryInt);
            dataModel.put("products", products);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}