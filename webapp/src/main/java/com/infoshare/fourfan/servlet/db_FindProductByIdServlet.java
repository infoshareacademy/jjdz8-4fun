package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.db_CategoryService;
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
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/db_findProductById")
public class db_FindProductByIdServlet extends HttpServlet {

    @Inject
    private db_ProductDao db_productDao;

    @Inject
    private db_ShopService db_shopService;

    @Inject
    private db_CategoryService db_categoryService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(db_FindProductByIdServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "db_findProductById.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<db_ProductDto> db_product = db_productDao.findProductIdDto(Integer.parseInt(idParam));

        Map<String, Object> dataModel = new HashMap<>();
        if (db_product.isPresent()){
            dataModel.put("product", db_product.get());
            dataModel.put("productId", db_product.get().getId());
            dataModel.put("shops", db_shopService.getShops());
            dataModel.put("categories", db_categoryService.getCategory());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
            printWriter.println("<script>\n" +
                    "        alert(\"Niepoprawne ID produktu!\")\n" +
                    "  top.window.location = '/db_editProduct';" +
                    "    </script>");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}