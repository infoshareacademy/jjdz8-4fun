package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.CategoryService;
import com.infoshare.fourfan.service.ShopService;
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

@WebServlet("/findProductByName")
public class FindProductByNameServlet extends HttpServlet {

    @Inject
    private ProductDao productDao;

    @Inject
    private ShopService shopService;

    @Inject
    private CategoryService db_categoryService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(FindProductByNameServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "findProductByName.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String nameParam = req.getParameter("name");

        if (nameParam == null || nameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<ProductDto> db_product = productDao.findProductNameDto(nameParam);

        Map<String, Object> dataModel = new HashMap<>();
        if (db_product.isPresent()){
            dataModel.put("product", db_product.get());
            dataModel.put("productId", db_product.get().getId());
            dataModel.put("shops", shopService.getShops());
            dataModel.put("categories", db_categoryService.getCategory());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
            printWriter.println("<script>\n" +
                    "        alert(\"Niepoprawne ID produktu!\")\n" +
                    "  top.window.location = '/editProduct';" +
                    "    </script>");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
