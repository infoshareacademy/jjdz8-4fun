package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_ProductCategoryServiceRobocze;
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

@WebServlet("/db_filterUserProductsByCategory")
public class db_FilterProductsForUserByCategory extends HttpServlet {

    @Inject
    private db_ProductDao db_productDao;

    @Inject
    private db_ProductCategoryServiceRobocze db_productCategoryServiceRobocze;

    private static final Logger logger = Logger.getLogger(db_FilterProductsForUserByCategory.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_filterByCategory.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String categoryParam = req.getParameter("category");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("categories", db_productCategoryServiceRobocze.getCategory());

        if(categoryParam != null && !categoryParam.equals("Wybierz") ){
            Optional<List<db_ProductDto>> products = db_productDao.findProductCategoryDto(Integer.parseInt(categoryParam));
            if (products.isPresent()){
                dataModel.put("products", products.get());
            } else {
                dataModel.put("errorMessage", "Product has not been found.");
            }
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}