package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_UserProductsDao;
import com.infoshare.fourfan.dto.db_UserProductsDto;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/db_deleteFromShoppingList")
public class db_DeleteFromShoppingListServlet extends HttpServlet {

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_UserProductsDao db_userProductsDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(db_DeleteFromShoppingListServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_showShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String productId = req.getParameter("id");

        if (productId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Integer IDuzytkownika = 1;
//        Optional<List<db_UserProductsDto>> db_userProducts = db_userProductsDao.findProductsUserIdDto(IDuzytkownika);


        db_productService.deleteProductFromUserList(Integer.parseInt(productId));

//        printWriter.println("<script>\n" +
//                "        alert(\"" + "produkt" + " został usunięty z listy zakupów!\")\n" +
//                "    </script>");

        resp.sendRedirect("/db_showShoppingList");
//        Map<String, Object> dataModel = new HashMap<>();
//        if (dataModel != null) {
//            dataModel.put("userProducts", db_userProductsDao.findProductsUserIdDto(IDuzytkownika));
//        } else {
//            dataModel.put("errorMessage", "Product has not been found.");
//        } try {
//            template.process(dataModel, printWriter);
//        } catch (TemplateException e) {
//            logger.severe(e.getMessage());
//        }
    }
}

