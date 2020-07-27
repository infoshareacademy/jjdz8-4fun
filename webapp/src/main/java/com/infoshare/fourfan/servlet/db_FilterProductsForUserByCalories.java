package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;
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

@WebServlet("/db_filterUserProductsByCalories")
public class db_FilterProductsForUserByCalories extends HttpServlet {

        @Inject
        private db_ProductDao db_productDao;

        private static final Logger logger
                = Logger.getLogger(FilterProductsForUserByCalories.class.getName());

        @Inject
        private TemplateProvider templateProvider;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();

            String minCalories = req.getParameter("min");
            String maxCalories = req.getParameter("max");

            Template template = templateProvider.getTemplate(getServletContext(), "db_filterByCalories.ftlh");
            Map<String, Object> dataModel = new HashMap<>();


            if(minCalories != null && maxCalories != null) {
                Integer minCaloriesInt = Integer.parseInt(minCalories);
                Integer maxCaloriesInt = Integer.parseInt(maxCalories);
                Optional<List<db_ProductDto>> db_product = db_productDao.findProductCaloriesDto(minCaloriesInt,maxCaloriesInt);

                if (db_product.isPresent()){
                    dataModel.put("products", db_product.get());
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
