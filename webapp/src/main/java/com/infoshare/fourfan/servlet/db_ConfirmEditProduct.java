package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.domain.datatypes.db_Product;
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
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/db_confirmEditProduct")
public class db_ConfirmEditProduct extends HttpServlet {

    private static final Logger logger = Logger.getLogger(db_ConfirmEditProduct.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ProductDao db_productDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String idParam = req.getParameter("id");

        Optional<db_Product> product = db_productDao.findById(Integer.parseInt(idParam));

        Template template = templateProvider.getTemplate(getServletContext(), "db_confirmEditProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", product);
        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
