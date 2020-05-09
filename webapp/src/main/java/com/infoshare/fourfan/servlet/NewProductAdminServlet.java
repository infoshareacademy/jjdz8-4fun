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
        Product product = new Product(req.getParameter("name"),req.getParameter("brand"),Integer.parseInt(req.getParameter("price")),Integer.parseInt(req.getParameter("calories")),Shop.valueOf(req.getParameter("shop")),ProductCategory.valueOf(req.getParameter("category")));

        adminService.save(product);
    }
}
