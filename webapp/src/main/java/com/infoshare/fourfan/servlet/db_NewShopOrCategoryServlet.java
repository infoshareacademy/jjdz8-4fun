package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_ProductCategoryServiceRobocze;
import com.infoshare.fourfan.service.db_ProductService;
import com.infoshare.fourfan.service.db_ShopServiceRobocze;
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

@WebServlet("/db_addShopOrCategory")
public class db_NewShopOrCategoryServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(db_NewShopOrCategoryServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_ShopServiceRobocze db_shopServiceRobocze;

    @Inject
    private db_ProductCategoryServiceRobocze db_productCategoryServiceRobocze;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_addShopOrCategory.ftlh");
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

        String nameCategory = req.getParameter("nameCategory");
        String nameShop = req.getParameter("nameShop");

        if (nameCategory != null) {
            db_productService.saveNewCategory(nameCategory);
            resp.sendRedirect("/db_categoryList");
        }

        if (nameShop != null) {
            db_productService.saveNewShop(nameShop);
            resp.sendRedirect("/db_shopList");
        }
    }
}
