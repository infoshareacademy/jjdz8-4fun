package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.AdminService;
import com.infoshare.fourfan.service.ProductService;
import com.infoshare.fourfan.service.db_ProductService;
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

@WebServlet("/db_editProduct")
public class db_editProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EditProductServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdminService adminService;

    @Inject
    private ProductService productService;

    @Inject
    private db_ProductService db_productService;

    @Inject
    private db_ProductDao db_productDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");


        Template template = templateProvider.getTemplate(getServletContext(), "db_editProduct.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
//        dataModel.put("products", productService.findAllJson());
        dataModel.put("products", db_productService.getProducts());
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

        Optional<db_ProductDto> db_oldProduct = db_productDao.findProductDto(Integer.parseInt(idParam));

        Integer id = Integer.parseInt(idParam);
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Integer shop = Integer.parseInt(req.getParameter("shop"));
        Integer productCategory = Integer.parseInt(req.getParameter("category"));

        db_productService.editProduct(id,name,brand,price,calories,shop,productCategory);

        resp.sendRedirect("/db_confirmEditProduct?id=" + db_oldProduct.get().getId());
    }
}


