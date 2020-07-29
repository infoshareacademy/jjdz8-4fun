package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_ShopService;
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

@WebServlet("/db_shopList")
public class db_ShopListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private db_ShopService db_shopService;

    private static final Logger logger = Logger.getLogger(db_ShopListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_shopList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("shops", db_shopService.getShops());

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
