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

@WebServlet("/delete-fromShoppingList")
public class DeleteFromShoppingListServlet extends HttpServlet {

    @Inject
    ShoppingListService shoppingListService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(DeleteFromShoppingListServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        Integer productId = Integer.valueOf(req.getParameter("id"));

        Template template = templateProvider.getTemplate(getServletContext(), "shoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        if (productId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product = shoppingListService.findProductSLById(productId);
        shoppingListService.deleteProductFromJson(product);


        printWriter.println("<script>\n" +
                "        alert(\"" + "produkt" + " został usunięty z listy zakupów!\")\n" +
                "    </script>");

        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null) {
            dataModel.put("shoppingListproducts", shoppingListService.findAllJson());

        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        } try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}

