package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
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

@WebServlet("/admin-filter-products-by-brand")
public class AdminFilterProductsByBrandServlet extends HttpServlet {

    private final String FILTER_PRODUCT_BY_BRAND_PATH = "admin-filter-products-by-brand.ftlh";

    private static final Logger logger = Logger.getLogger(com.infoshare.fourfan.servlet.AdminFilterProductsByBrandServlet.class.getName());

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String brandParam = req.getParameter("brand");
        PrintWriter writer = resp.getWriter();

        Template template = templateProvider.getTemplate(getServletContext(), FILTER_PRODUCT_BY_BRAND_PATH);
        Map<String, Object> dataModel = new HashMap<>();

        if (brandParam != null || brandParam.isBlank()) {
            Integer brandInt = Integer.parseInt(brandParam);
            List<Product> products = productService.filterProductsByBrand(brandInt);
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