package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.CategoryService;
import com.infoshare.fourfan.service.ProductService;
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

@WebServlet("/addProduct")
public class NewProductAdminServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(NewProductAdminServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProductService productService;

    @Inject
    private ProductDao productDao;

    @Inject
    private ShopService shopService;

    @Inject
    private CategoryService db_categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addProduct.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("shops", shopService.getShops());
        dataModel.put("categories", db_categoryService.getCategory());

        PrintWriter printWriter = resp.getWriter();

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
        PrintWriter printWriter = resp.getWriter();

        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Integer shop = Integer.parseInt(req.getParameter("shop"));
        Integer productCategory = Integer.parseInt(req.getParameter("category"));

        Optional<ProductDto> db_product = productDao.findAlreadyExistProductDto(name,brand);

        if(db_product.isEmpty()){
            productService.saveNewProductDB(name,brand,price,calories,shop,productCategory);

            resp.sendRedirect("/confirmNewProduct");
        }else{
            printWriter.println("<script>\n" +
                    "alert(\"Mamy już taki produkt tego producenta!\")\n" +
                    "top.window.location = '/addProduct';" +
                    "</script>");
        }
    }
}
