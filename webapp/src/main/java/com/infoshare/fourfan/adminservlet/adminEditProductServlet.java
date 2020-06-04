package com.infoshare.fourfan.adminservlet;

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
}