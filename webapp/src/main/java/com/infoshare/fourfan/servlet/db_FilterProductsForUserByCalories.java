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

    public enum CaloriesRangeEnum {
        RANGE_0_150,
        RANGE_151_300,
        RANGE_FROM_301;
    }

    @Inject
    private db_ProductDao db_productDao;

    private static final Logger logger = Logger.getLogger(FilterProductsForUserByCalories.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String calories = req.getParameter("calories");


        Template template = templateProvider.getTemplate(getServletContext(), "db_filterByCalories.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("firstRange", CaloriesRangeEnum.RANGE_0_150);
        dataModel.put("secondRange", CaloriesRangeEnum.RANGE_151_300);
        dataModel.put("thirdRange", CaloriesRangeEnum.RANGE_FROM_301);

        if(calories != null && !calories.equals("Przedzial") ) {
            CaloriesRangeEnum caloriesRangeEnum = CaloriesRangeEnum.valueOf(calories);
            CaloriesRange caloriesRange = new CaloriesRange(caloriesRangeEnum).invoke();
            int productMin = caloriesRange.getProductMin();
            int productMax = caloriesRange.getProductMax();

            Optional<List<db_ProductDto>> db_product = db_productDao.findProductCaloriesDto(productMin,productMax);

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

    private static class CaloriesRange {
        private CaloriesRangeEnum caloriesRange;
        private int productMin;
        private int productMax;

        public CaloriesRange(CaloriesRangeEnum caloriesRange) {
            this.caloriesRange = caloriesRange;
        }

        public int getProductMin() {
            return productMin;
        }

        public int getProductMax() {
            return productMax;
        }

        public CaloriesRange invoke() {
            productMin = -1;
            productMax = 1000000000;

            switch (caloriesRange) {
                case RANGE_0_150:
                    productMin = 0;
                    productMax = 150;
                    break;
                case RANGE_151_300:
                    productMin = 151;
                    productMax = 300;
                    break;
                case RANGE_FROM_301:
                    productMin = 301;
                    productMax = 100000000;
                    break;
            }
            return this;
        }
    }
}

