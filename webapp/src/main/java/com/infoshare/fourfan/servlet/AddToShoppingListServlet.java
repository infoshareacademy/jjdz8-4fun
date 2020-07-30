package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.dto.ProductDto;
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
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;


@WebServlet("/addToShoppingList")
public class AddToShoppingListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProductService productService;

    @Inject
    private ProductDao productDao;

    @Inject
    private UserProductsDao userProductsDao;

    private static final Logger logger = Logger.getLogger(AddToShoppingListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addToShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", productService.getProducts());
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

        Optional<ProductDto> add_db_product = productDao.findProductIdDto(Integer.parseInt(productIdParam));

        Integer productId = add_db_product.get().getId();
        String name = add_db_product.get().getName();

        Integer userId = 1;
        if(userProductsDao.findUserProductNameDto(name).isPresent()) {
            Integer productIdInList = userProductsDao.findUserProductNameDto(name).get().getId();
            Integer amount = userProductsDao.findUserProductNameDto(name).get().getProductAmount();
            productService.editProductFromUserList(productIdInList,amount+1);
        }
        else {
            productService.saveProductToUserList(userId,productId);
        }

        resp.sendRedirect("/showShoppingList");
    }
}
