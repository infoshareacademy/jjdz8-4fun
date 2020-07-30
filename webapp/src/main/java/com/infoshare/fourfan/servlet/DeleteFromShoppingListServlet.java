package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ProductService;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/deleteFromShoppingList")
public class DeleteFromShoppingListServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Inject
    private UserProductsDao userProductsDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(DeleteFromShoppingListServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "showShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String productId = req.getParameter("id");

        if (productId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        productService.deleteProductFromUserList(Integer.parseInt(productId));

        resp.sendRedirect("/showShoppingList");
    }
}

