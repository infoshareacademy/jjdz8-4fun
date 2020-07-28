package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_UserProductsDao;
import com.infoshare.fourfan.service.ShoppingListService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/db_deleteAllShoppingList")
public class db_DeleteAllShoppingListServlet extends HttpServlet {

    @Inject
    db_UserProductsDao db_userProductsDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String idParam = req.getParameter("id");

        db_userProductsDao.deleteAllUserShoppingList(Integer.parseInt(idParam));

        resp.sendRedirect("/db_confirmRemoveAllList");

    }
}

