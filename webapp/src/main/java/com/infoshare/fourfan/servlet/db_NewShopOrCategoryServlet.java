package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;
import com.infoshare.fourfan.dto.db_ShopDto;
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
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/db_addShopOrCategory")
public class db_NewShopOrCategoryServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(db_NewShopOrCategoryServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_ProductCategoryDao db_productCategoryDao;

    @Inject
    private db_ShopDao db_shopDao;

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
        PrintWriter printWriter = resp.getWriter();

        String nameCategory = req.getParameter("nameCategory");
        String nameShop = req.getParameter("nameShop");

        if (nameCategory != null) {

            Optional<db_ProductCategoryDto> db_productCategory = db_productCategoryDao.findAlreadyExistProductCategoryDto(nameCategory);

            if(db_productCategory.isEmpty()){
                db_productService.saveNewCategory(nameCategory);
                resp.sendRedirect("/db_categoryList");
            }else{
                printWriter.println("<script>\n" +
                        "        alert(\"Mamy już taką kategorie!\")\n" +
                        "  top.window.location = '/db_addShopOrCategory';" +
                        "    </script>");
            }
        }

        if (nameShop != null) {
            Optional<db_ShopDto> db_shop = db_shopDao.findAlreadyExistShopDto(nameShop);

            if(db_shop.isEmpty()){
                db_productService.saveNewShop(nameShop);
                resp.sendRedirect("/db_shopList");
            }else{
                printWriter.println("<script>\n" +
                        "        alert(\"Mamy już taki sklep!\")\n" +
                        "  top.window.location = '/db_addShopOrCategory';" +
                        "    </script>");
            }
        }
    }
}
