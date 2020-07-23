package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ShoppingListService;
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
import java.util.logging.Logger;

@WebServlet("/editProductList")
public class EditProductListServlet extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(EditProductListServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ShoppingListService shoppingListService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String idParam3 = req.getParameter("id");

        if (idParam3 == null || idParam3.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product = shoppingListService.findProductSLById(Integer.valueOf(idParam3));
        PrintWriter printWriter = resp.getWriter();

        Template template = templateProvider.getTemplate(getServletContext(), "editProductList.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null && product!= null){
            dataModel.put("product", product);
            dataModel.put("productId", idParam3);
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

        Integer productId = Integer.valueOf(req.getParameter("id"));
        Product oldProduct2 = shoppingListService.findProductSLById(productId);

        oldProduct2.setName(req.getParameter("name"));
        oldProduct2.setAmount(Integer.parseInt(req.getParameter("amount")));

        shoppingListService.editProductList(productId, oldProduct2);

        resp.sendRedirect("/confirmEditShoppingList?id=" + oldProduct2.getId());
    }
}


