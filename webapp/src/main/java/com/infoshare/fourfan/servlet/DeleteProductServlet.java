package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.dto.UserProductsDto;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Inject
    private UserProductsDao userProductsDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(DeleteProductServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "productList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<List<UserProductsDto>> db_product = userProductsDao.findUserProductIdProductDto(Integer.parseInt(idParam));

        if(db_product.get().isEmpty()){
        productService.deleteProduct(Integer.parseInt(idParam));
        printWriter.println("<script>\n" +
                "alert(\"Produkt został usunięty!\")\n" +
                "top.window.location = '/productList';" +
                "</script>");
        }else{
        printWriter.println("<script>\n" +
                "alert(\"Nie możemy usunąć produktu! jest powiązany z listą użytkownika!\")\n" +
                "top.window.location = '/productList';" +
                "</script>");
        }

        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null) {
            dataModel.put("products", productService.getProducts());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        } try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
