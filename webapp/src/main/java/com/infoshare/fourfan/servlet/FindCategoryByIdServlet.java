package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductCategoryDao;
import com.infoshare.fourfan.dto.ProductCategoryDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
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
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/findCategoryById")
public class FindCategoryByIdServlet extends HttpServlet {

    @Inject
    private ProductCategoryDao productCategoryDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(FindCategoryByIdServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "findCategoryById.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<ProductCategoryDto> db_productCategory = productCategoryDao.findCategoryIdDto(Integer.parseInt(idParam));

        Map<String, Object> dataModel = new HashMap<>();
        if (!UserContext.requireUserContext(req, resp, dataModel)) {
            return;
        }
        if (db_productCategory.isPresent()){
            dataModel.put("category", db_productCategory.get());
            dataModel.put("categoryId", db_productCategory.get().getId());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
