package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
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
import java.util.logging.Logger;

@WebServlet("/admin-delete-product")
public class adminDeleteProductServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(adminDeleteProductServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "common/adminTemp/product-list.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String nameParam = req.getParameter("name");

        if (nameParam == null || nameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product = productService.findProductByName(nameParam);
        productService.deleteProductFromJson(product);

        printWriter.println("<script>\n" +
                "        alert(\"" + product.getName() + " został usunięty!\")\n" +
                "    </script>");

        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null) {
            dataModel.put("products", productService.findAllJson());

        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        } try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
