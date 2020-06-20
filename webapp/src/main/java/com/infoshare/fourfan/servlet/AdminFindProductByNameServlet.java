package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.service.ProductService;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.service.UserService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/admin-find-product-by-id")
public class AdminFindProductByNameServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminFindProductByNameServlet.class.getName());

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nameParam = req.getParameter("name");

        if (nameParam == null || nameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product = productService.findProductByName(nameParam);

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        if (product != null) {
            writer.println("ID: " + product.getId() + "<br>");
            writer.println("Name: " + product.getName() + "<br>");
            writer.println("Brand: " + product.getBrand() + "<br>");
            writer.println("Price: " + product.getPrice() + "<br>");
            writer.println("Calories: " + product.getCalories() + "<br>");
            writer.println("Shop: " + product.getShop() + "<br>");
            writer.println("Product category: " + product.getProductCategory() + "<br>");
        } else {
            writer.println("User has not been found - no ID available");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}