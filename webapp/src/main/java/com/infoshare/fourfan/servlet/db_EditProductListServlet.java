package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_UserProductsDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.db_UserProductsDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ShoppingListService;
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

@WebServlet("/db_editProductList")
public class db_EditProductListServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(db_EditProductListServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ShoppingListService shoppingListService;

    @Inject
    private db_UserProductsDao db_userProductsDao;

    @Inject
    private db_ShopServiceRobocze db_shopServiceRobocze;

    @Inject
    private db_ProductCategoryServiceRobocze db_productCategoryServiceRobocze;

    @Inject
    private db_ProductService db_productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_editProductList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<db_UserProductsDto> db_userProducts = db_userProductsDao.findOneProductUserIdDto(Integer.parseInt(idParam));

        Map<String, Object> dataModel = new HashMap<>();
        if (db_userProducts.isPresent()){
            dataModel.put("product", db_userProducts.get());
            dataModel.put("productId", db_userProducts.get().getId());
            dataModel.put("shops", db_shopServiceRobocze.getShops());
            dataModel.put("categories", db_productCategoryServiceRobocze.getCategory());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        }
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

        String productId = req.getParameter("id");

        Optional<db_UserProductsDto> db_userProductsNew = db_userProductsDao.findOneProductUserIdDto(Integer.parseInt(productId));

        Integer id = Integer.parseInt(productId);
        Integer amount = Integer.parseInt(req.getParameter("amount"));

        db_productService.editProductFromUserList(id, amount);

        resp.sendRedirect("/db_confirmEditShoppingList?id=" + db_userProductsNew.get().getId());
    }
}


