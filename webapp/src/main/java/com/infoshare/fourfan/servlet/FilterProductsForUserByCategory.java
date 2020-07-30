package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.CategoryService;
import com.infoshare.fourfan.utils.UserContext;
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

@WebServlet("/filterUserProductsByCategory")
public class FilterProductsForUserByCategory extends HttpServlet {

    @Inject
    private ProductDao productDao;

    @Inject
    private CategoryService db_categoryService;

    private static final Logger logger = Logger.getLogger(FilterProductsForUserByCategory.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "filterByCategory.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String categoryParam = req.getParameter("category");

        Map<String, Object> dataModel = new HashMap<>();
        if (!UserContext.requireUserContext(req, resp, dataModel)) {
            return;
        }
        dataModel.put("categories", db_categoryService.getCategory());

        if(categoryParam != null && !categoryParam.equals("Wybierz") ){
            Optional<List<ProductDto>> products = productDao.findProductCategoryDto(Integer.parseInt(categoryParam));
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