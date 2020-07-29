package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_CategoryService;
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

@WebServlet("/db_editCategory")
public class db_editCategoryServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EditProductServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_CategoryService db_categoryService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_editCategory.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("categories", db_categoryService.getCategory());
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

        String idParam = req.getParameter("id");

        Integer id = Integer.parseInt(idParam);
        String name = req.getParameter("name");

        db_categoryService.editCategory(id,name);

        resp.sendRedirect("/db_categoryList");
    }
}
