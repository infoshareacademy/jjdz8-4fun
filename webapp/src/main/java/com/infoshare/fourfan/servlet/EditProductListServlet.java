package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.dto.UserProductsDto;
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

@WebServlet("/editProductList")
public class EditProductListServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EditProductListServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserProductsDao userProductsDao;

    @Inject
    private ShopService shopService;

    @Inject
    private CategoryService db_categoryService;

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "editProductList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<UserProductsDto> db_userProducts = userProductsDao.findOneProductUserIdDto(Integer.parseInt(idParam));

        Map<String, Object> dataModel = new HashMap<>();
        if (db_userProducts.isPresent()){
            dataModel.put("product", db_userProducts.get());
            dataModel.put("productId", db_userProducts.get().getId());
            dataModel.put("shops", shopService.getShops());
            dataModel.put("categories", db_categoryService.getCategory());
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

        Optional<UserProductsDto> db_userProductsNew = userProductsDao.findOneProductUserIdDto(Integer.parseInt(productId));

        Integer id = Integer.parseInt(productId);
        Integer amount = Integer.parseInt(req.getParameter("amount"));

        productService.editProductFromUserList(id, amount);

        resp.sendRedirect("/confirmEditShoppingList?id=" + db_userProductsNew.get().getId());
    }
}


