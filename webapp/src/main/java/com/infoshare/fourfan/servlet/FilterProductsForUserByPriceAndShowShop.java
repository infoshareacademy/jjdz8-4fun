package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.utils.UserContext;
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

@WebServlet("/filterByPriceAndShop")
public class FilterProductsForUserByPriceAndShowShop extends HttpServlet {

    @Inject
    private ProductDao productDao;

    private static final Logger logger = Logger.getLogger(FilterProductsForUserByPriceAndShowShop.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = templateProvider.getTemplate(getServletContext(), "filterByPriceAndShop.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        if (!UserContext.requireUserContext(req, resp, dataModel)) {
            return;
        }
        String priceMinAndShop = req.getParameter("priceMin");
        String priceMaxAndShop = req.getParameter("priceMax");

        if(priceMinAndShop != null && !priceMinAndShop.isEmpty() && priceMaxAndShop != null && !priceMaxAndShop.isEmpty()) {
            Integer priceMinInt = Integer.parseInt(priceMinAndShop);
            Integer priceMaxInt = Integer.parseInt(priceMaxAndShop);

            Optional<List<ProductDto>> db_product = productDao.filterByPrice(priceMinInt, priceMaxInt);

            dataModel.put("products", db_product.get());
            dataModel.put("priceMin", priceMinAndShop);
            dataModel.put("priceMax", priceMaxAndShop);
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
