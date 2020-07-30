package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.dto.UserProductsDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
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

@WebServlet("/showShoppingList")
public class ShowShoppingListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserProductsDao userProductsDao;

    private static final Logger logger = Logger.getLogger(ShowShoppingListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "showShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Integer IDuzytkownika = 1;
        Optional<List<UserProductsDto>> db_userProducts = userProductsDao.findProductsUserIdDto(IDuzytkownika);

        Map<String, Object> dataModel = new HashMap<>();
//        if (db_userProducts.isPresent()){
            dataModel.put("userProducts", db_userProducts.get());
//        } else {
//            dataModel.put("errorMessage", "Product has not been found.");
//        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
