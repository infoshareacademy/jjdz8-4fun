package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.servlet.config.WebInfPathResolver;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet("/confirmNewProduct")
public class ConfirmNewProduct extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(ConfirmNewProduct.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    private static final String PRODUCTS_FILE_NAME = "Products.json";
    @Inject
    private WebInfPathResolver webInfPathResolver;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "confirmNewProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
        String abc = Objects.requireNonNull(this.getClass().getClassLoader().getResource("Products.json")).getPath();
        resp.getWriter().println(abc);
        resp.getWriter().println("-------");
        String jsonFilePath = webInfPathResolver.getFilePath(PRODUCTS_FILE_NAME);
        resp.getWriter().println(jsonFilePath);
    }
}