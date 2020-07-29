package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_CategoryService;
import com.infoshare.fourfan.service.db_ProductService;
import com.infoshare.fourfan.service.db_ShopService;
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

@WebServlet("/db_addProduct")
public class db_NewProductAdminServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(db_NewProductAdminServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_ShopDao db_shopDao;

    @Inject
    private db_ProductDao db_productDao;

    @Inject
    private db_ProductCategoryDao db_productCategoryDao;

    @Inject
    private db_ShopService db_shopService;

    @Inject
    private db_CategoryService db_categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_addProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (db_shopService.getShops().size() == 0) {
            db_Shop db_shop2 = new db_Shop();
            db_shop2.setShop("sklep2");
            db_shopDao.save(db_shop2);
        }
        if (db_categoryService.getCategory().size() == 0) {
            db_ProductCategory db_productCategory2 = new db_ProductCategory();
            db_productCategory2.setCategory("kategoria2");
            db_productCategoryDao.save(db_productCategory2);
        }

        dataModel.put("shops", db_shopService.getShops());
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

        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Integer shop = Integer.parseInt(req.getParameter("shop"));
        Integer productCategory = Integer.parseInt(req.getParameter("category"));

        Optional<db_ProductDto> db_product = db_productDao.findAlreadyExistProductDto(name,brand);

        if(db_product.isEmpty()){
            db_productService.saveNewProductDB(name,brand,price,calories,shop,productCategory);
            resp.sendRedirect("/confirmNewProduct");
        }else{
            printWriter.println("<script>\n" +
                    "alert(\"Mamy już taki produkt tego producenta!\")\n" +
                    "top.window.location = '/db_addProduct';" +
                    "</script>");
        }
    }
}
