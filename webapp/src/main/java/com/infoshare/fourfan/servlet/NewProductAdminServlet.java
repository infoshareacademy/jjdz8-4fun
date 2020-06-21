package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.AdminService;
import com.infoshare.fourfan.service.ProductServiceDb;
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

@WebServlet("/addProduct")
public class NewProductAdminServlet extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(NewProductAdminServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Shop shop = Shop.valueOf(req.getParameter("shop"));
        ProductCategory category = ProductCategory.valueOf(req.getParameter("category"));
        Integer id = 0;
        Product product = new Product(id,name,brand,price,calories,shop,category);

        adminService.saveNewProduct(product);

        resp.sendRedirect("/confirmNewProduct");
    }
}
