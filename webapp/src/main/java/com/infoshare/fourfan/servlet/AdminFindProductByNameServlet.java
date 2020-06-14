package com.infoshare.fourfan.servlet;

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

    private static final Logger logger = Logger.getLogger(com.isa.usersengine.servlet.FindUserByIdServlet.class.getName());

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User user = userService.findById(Long.parseLong(idParam));

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        if (user != null) {
            writer.println("ID: " + user.getId() + "<br>");
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