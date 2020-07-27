package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.service.ShoppingListService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAllShoppingList")
public class DeleteAllShoppingListServlet extends HttpServlet {

    @Inject
    ShoppingListService shoppingListService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        shoppingListService.deleteAllShoppingList();
        resp.sendRedirect("/confirmRemoveAllList");

    }
}

