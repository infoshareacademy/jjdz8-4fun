package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dao.db_UserProductsDao;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
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
import java.util.Optional;
import java.util.logging.Logger;


@WebServlet("/db_addToShoppingList")
public class db_AddToShoppingListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_ProductDao db_productDao;

    @Inject
    private db_UserProductsDao db_userProductsDao;

    private static final Logger logger = Logger.getLogger(ProductListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_addToShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", db_productService.getProducts());
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

        String productIdParam = req.getParameter("id");

        Optional<db_ProductDto> add_db_product = db_productDao.findProductIdDto(Integer.parseInt(productIdParam));

        Integer productId = add_db_product.get().getId();
        String name = add_db_product.get().getName();

        Integer userId = 1;
        if(db_userProductsDao.findUserProductNameDto(name).isPresent()) {
            Integer productIdInList = db_userProductsDao.findUserProductNameDto(name).get().getId();
            Integer amount = db_userProductsDao.findUserProductNameDto(name).get().getProductAmount();
            db_productService.editProductFromUserList(productIdInList,amount+1);
        }
        else {
            db_productService.saveProductToUserList(userId,productId);
        }

        resp.sendRedirect("/db_showShoppingList");
    }
}
