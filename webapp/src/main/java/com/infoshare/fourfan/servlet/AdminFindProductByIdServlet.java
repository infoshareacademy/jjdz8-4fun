package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
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

@WebServlet("/admin-find-product-by-id")
public class AdminFindProductByIdServlet extends HttpServlet {

    private final String FIND_PRODUCT_BY_ID_PATH = "admin-find-product-by-id.ftlh";

    private static final Logger logger = Logger.getLogger(AdminFindProductByIdServlet.class.getName());

    @Inject
    private ProductService productService;

    @Inject
    private AdminService adminService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String idParam = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        Product product = adminService.findProductById(Integer.valueOf(idParam));

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), FIND_PRODUCT_BY_ID_PATH);

        Map<String, Object> dataModel = new HashMap<>();
        if (product != null) {
            dataModel.put("product", adminService.findProductById(Integer.valueOf(idParam)));
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        }

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}