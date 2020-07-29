package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.AdminService;
import com.infoshare.fourfan.service.ProductService;
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
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/confirmEditProduct")
public class ConfirmEditProduct extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(ConfirmEditProduct.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        if (!UserContext.requireAdminContext(req, resp, dataModel)) {
            return;
        }

        Long idParam = Long.parseLong(req.getParameter("id"));
        Product product = adminService.findProductById(Math.toIntExact(idParam));

        Template template = templateProvider.getTemplate(getServletContext(), "confirmEditProduct.ftlh");
        dataModel.put("product", product);
        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
