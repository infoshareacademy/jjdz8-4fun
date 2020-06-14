package com.infoshare.fourfan.storage;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.repository.AdminRepositoryBean;
import com.infoshare.fourfan.service.AdminService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RoboczyServletShowProduct")
public class RoboczyServletShowProduct extends HttpServlet {

    @Inject
    private AdminService adminService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html><html><body>");

        Product product = new AdminRepositoryBean().findProductById(1);

        Product product1 = new Product();
        product1.setName("Zupa ogórkowa");
        ProductList productList = new ProductList();

        resp.getWriter().println(new AdminRepositoryBean().showAllProducts().size());
        resp.getWriter().println(adminService.findProductById(1));
        resp.getWriter().println(adminService.findProductById(1));






        writer.println("</body></html>");
    }
}