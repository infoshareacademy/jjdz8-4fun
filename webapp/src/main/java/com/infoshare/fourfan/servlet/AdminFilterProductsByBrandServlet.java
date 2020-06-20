package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.service.ProductService;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/admin-filter-products-by-brand")
public class AdminFilterProductsByBrandServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminFilterProductsByBrandServlet.class.getName());

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String brandParam = req.getParameter("brand");

        if (brandParam == null || brandParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        List<Product> brandProductList = productService.filterByBrand(brandParam);

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        if (brandProductList != null) {
            writer.println("ID: " + brandProductList.() + "<br>");
            writer.println("Name: " + user.getName() + "<br>");
            writer.println("Login: " + user.getLogin() + "<br>");
            writer.println("Password: " + user.getPassword() + "<br>");
            writer.println("Age: " + user.getAge() + "<br>");
        } else {
            writer.println("User has not been found - no ID available");
        }

        writer.println("</body>");
        writer.println("</html>");

    }
}