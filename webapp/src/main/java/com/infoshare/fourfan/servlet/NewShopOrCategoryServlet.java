package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductCategoryDao;
import com.infoshare.fourfan.dao.ShopDao;
import com.infoshare.fourfan.dto.ProductCategoryDto;
import com.infoshare.fourfan.dto.ShopDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.*;
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

@WebServlet("/addShopOrCategory")
public class NewShopOrCategoryServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(NewShopOrCategoryServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CategoryService db_categoryService;

    @Inject
    private ShopService shopService;

    @Inject
    private ProductCategoryDao productCategoryDao;

    @Inject
    private ShopDao shopDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addShopOrCategory.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("shops", shopService.getShops());
        dataModel.put("categories", db_categoryService.getCategory());

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

            Optional<ProductCategoryDto> db_productCategory = productCategoryDao.findAlreadyExistProductCategoryDto(nameCategory);

            if(db_productCategory.isEmpty()){
                db_categoryService.saveNewCategory(nameCategory);
                resp.sendRedirect("/categoryList");
            }else{
                printWriter.println("<script>\n" +
                        "        alert(\"Mamy już taką kategorie!\")\n" +
                        "  top.window.location = '/addShopOrCategory';" +
                        "    </script>");
            }
        }

        if (nameShop != null) {
            Optional<ShopDto> db_shop = shopDao.findAlreadyExistShopDto(nameShop);

            if(db_shop.isEmpty()){
                shopService.saveNewShop(nameShop);
                resp.sendRedirect("/shopList");
            }else{
                printWriter.println("<script>\n" +
                        "        alert(\"Mamy już taki sklep!\")\n" +
                        "  top.window.location = '/addShopOrCategory';" +
                        "    </script>");
            }
        }
    }
}
