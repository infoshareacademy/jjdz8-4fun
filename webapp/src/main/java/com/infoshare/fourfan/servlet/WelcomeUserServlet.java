package com.infoshare.fourfan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");

            if (name == null || name.isEmpty()) {
                resp.setStatus((HttpServletResponse.SC_BAD_REQUEST));
                return;
            }

            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>");
            writer.println("Hello " + name + "!");
            writer.println("</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}