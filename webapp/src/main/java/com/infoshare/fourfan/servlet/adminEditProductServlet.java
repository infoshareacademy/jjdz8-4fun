package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ProductService;
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
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/admin-edit-product")
public class adminEditProductServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(adminEditProductServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "common/adminTemp/admin-edit-product.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", productService.findAllJson());

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Long idParam = Long.parseLong(req.getParameter("id"));
        String nameParam = req.getParameter("name");
        String brandParam = req.getParameter("brand");
        Integer priceParam = Integer.parseInt(req.getParameter("price"));
        Integer calParam = Integer.parseInt(req.getParameter("calories"));
        Shop shopParam = Shop.valueOf(req.getParameter("shop"));
        ProductCategory catParam = ProductCategory.valueOf(req.getParameter("category"));

        if (nameParam == null || nameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if (brandParam == null || brandParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        PrintWriter printWriter = resp.getWriter();
        Product product = productService.findProductById(idParam);

        product.setId(idParam);
        product.setName(nameParam);
        product.setBrand(brandParam);
        product.setPrice(priceParam);
        product.setCalories(calParam);
        product.setShop(shopParam);
        product.setProductCategory(catParam);

        Template template = templateProvider.getTemplate(getServletContext(), "common/adminTemp/admin-edit-product.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null){
            dataModel.put("product", product);

        } else {
            dataModel.put("errorMessage", "User has not been found.");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
