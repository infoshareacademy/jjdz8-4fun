package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_AdminService;
import com.infoshare.fourfan.service.db_ShopServiceRobocze;
import com.infoshare.fourfan.service.db_ProductCategoryServiceRobocze;
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
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet("/addProduct")
public class NewProductAdminServlet extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(NewProductAdminServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_AdminService db_adminService;

    @Inject
    private db_ShopServiceRobocze db_shopServiceRobocze;

    @Inject
    private db_ProductCategoryServiceRobocze db_productCategoryServiceRobocze;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("shops", db_shopServiceRobocze.getShops());
        dataModel.put("categories", db_productCategoryServiceRobocze.getCategory());

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
        Integer shop = Integer.parseInt(req.getParameter("shop"));
        Integer productCategory = Integer.parseInt(req.getParameter("category"));

        db_adminService.saveNewProductDB(name,brand,price,calories,shop,productCategory);

        resp.sendRedirect("/confirmNewProduct");
    }
}
