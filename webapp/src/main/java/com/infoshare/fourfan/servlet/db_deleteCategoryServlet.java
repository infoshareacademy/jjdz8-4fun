package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/db_deleteCategory")
public class db_deleteCategoryServlet extends HttpServlet {

    @Inject
    private db_CategoryService db_categoryService;

    @Inject
    private db_ProductDao db_productDao;

    @Inject
    private TemplateProvider templateProvider;


    private static final Logger logger = Logger.getLogger(db_deleteCategoryServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_categoryList.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<List<db_ProductDto>> db_product = db_productDao.findProductCategoryDto(Integer.parseInt(idParam));


        if(db_product.get().isEmpty()){

        db_categoryService.deleteCategory(Integer.parseInt(idParam));
        printWriter.println("<script>\n" +
                "alert(\"Kategoria została usunięta!\")\n" +
                "top.window.location = '/db_categoryList';" +
                "</script>");
        }else{
            printWriter.println("<script>\n" +
                    "alert(\"Nie możemy usunąć kategorii! jest powiązana z produktem!\")\n" +
                    "top.window.location = '/db_categoryList';" +
                    "</script>");
        }

        Map<String, Object> dataModel = new HashMap<>();
        if (dataModel != null) {
            dataModel.put("categories", db_categoryService.getCategory());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        } try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
