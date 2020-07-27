package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
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

@WebServlet("/db_filterByPriceAndShop")
public class db_FilterProductsForUserByPriceAndShowShop extends HttpServlet {

    @Inject
    private db_ProductDao db_productDao;

    private static final Logger logger = Logger.getLogger(db_FilterProductsForUserByPriceAndShowShop.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = templateProvider.getTemplate(getServletContext(), "db_filterByPriceAndShop.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        String minPrice = req.getParameter("priceMin");
        String maxPrice = req.getParameter("priceMax");

        if(maxPrice != null && !maxPrice.isEmpty()) {
            Integer minpriceInt = Integer.parseInt(minPrice);
            Integer maxpriceInt = Integer.parseInt(maxPrice);
            Optional<List<db_ProductDto>> db_product = db_productDao.filterByPrice(minpriceInt, maxpriceInt);

            dataModel.put("products", db_product.get());
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
