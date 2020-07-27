package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.ProductService;
import com.infoshare.fourfan.service.ShoppingListService;
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


@WebServlet("/addToShoppingList")
public class AddToShoppingListServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Inject
    private ShoppingListService shoppingListService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(ProductListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "addToShoppingList.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("products", productService.findAllJson());

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

        Integer productId = Integer.valueOf(req.getParameter("id"));
        Product oldProduct= productService.findProductById(productId);


        String name = oldProduct.getName();

        Integer id = productId;
        String brand = oldProduct.getBrand();
        Integer price = oldProduct.getPrice();
        Integer calories = oldProduct.getCalories();
        Shop shop = oldProduct.getShop();
        ProductCategory category = oldProduct.getProductCategory();
        Integer amount = 1;
        try {
            Product product222 = shoppingListService.findOnShoppingListByName(name);
            amount = product222.getAmount()+1;
            id = product222.getId();
            shoppingListService.deleteProductFromJson(product222);


        }
     catch (NullPointerException n) {

     }



         Product newShoppingListProduct = new Product(id, name, brand, price, calories, shop, category, amount);


         shoppingListService.saveNewShoppingList(newShoppingListProduct);



        resp.sendRedirect("/confirmNewShoppingList");

    }
}


