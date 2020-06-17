package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.AdminService;
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

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(EditProductServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdminService adminService;

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");


        Template template = templateProvider.getTemplate(getServletContext(), "admin-edit-product.ftlh");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Integer productId = Integer.valueOf(req.getParameter("id"));
        Product oldProduct = productService.findProductById(productId);

        oldProduct.setName(req.getParameter("name"));
        oldProduct.setBrand(req.getParameter("brand"));
        oldProduct.setPrice(Integer.parseInt(req.getParameter("price")));
        oldProduct.setCalories(Integer.parseInt(req.getParameter("calories")));
        oldProduct.setShop(Shop.valueOf(req.getParameter("shop")));
        oldProduct.setProductCategory(ProductCategory.valueOf(req.getParameter("category")));

        adminService.editProduct(productId, oldProduct);


        resp.sendRedirect("/confirmEditProduct?id=" + oldProduct.getId());
    }
}


