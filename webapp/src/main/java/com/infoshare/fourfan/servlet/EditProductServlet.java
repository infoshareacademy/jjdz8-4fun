package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
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
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EditProductServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProductService productService;

    @Inject
    private ProductDao productDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "editProduct.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        if (!UserContext.requireAdminContext(req, resp, dataModel)) {
            return;
        }
        dataModel.put("products", productService.getProducts());
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

        Optional<ProductDto> db_oldProduct = productDao.findProductIdDto(Integer.parseInt(idParam));

        Integer id = Integer.parseInt(idParam);
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Integer shop = Integer.parseInt(req.getParameter("shop"));
        Integer productCategory = Integer.parseInt(req.getParameter("category"));

        productService.editProduct(id,name,brand,price,calories,shop,productCategory);

        resp.sendRedirect("/confirmEditProduct?id=" + db_oldProduct.get().getId());
    }
}


