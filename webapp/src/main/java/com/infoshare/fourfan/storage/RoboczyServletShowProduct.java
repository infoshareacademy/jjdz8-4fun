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


        Product product = adminService.findProductById(1);
//
//        resp.getWriter().println(new AdminRepositoryBean().showAllProducts().size());
//        resp.getWriter().println(adminService.findProductById(1));
//        resp.getWriter().println(adminService.findProductById(1));

        adminService.showAllProducts().getProductList();

        resp.getWriter().println(adminService.showAllProducts().getProductList());
        resp.getWriter().println("=====");
        resp.getWriter().println(adminService.findProductById(Math.toIntExact(product.getId())));
        resp.getWriter().println("=====");
        resp.getWriter().println(product);





        writer.println("</body></html>");
    }
}