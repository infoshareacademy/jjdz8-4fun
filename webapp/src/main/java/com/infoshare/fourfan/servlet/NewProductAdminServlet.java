package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.service.AdminService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("addProduct")
public class NewProductAdminServlet extends HttpServlet {

    @Inject
    private AdminService adminService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer calories = Integer.parseInt(req.getParameter("calories"));
        Shop shop = Shop.valueOf(req.getParameter("shop"));
        ProductCategory category = ProductCategory.valueOf(req.getParameter("category"));

        resp.setContentType("text/html;charset=UTF-8");

        Product product = new Product(name,brand,price,calories,shop,category);

        adminService.saveNewProduct(product);
    }
}
