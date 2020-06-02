package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.repository.AdminRepositoryBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RoboczyServletShowProduct")
public class RoboczyServletShowProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html><html><body>");
        resp.getWriter().println(new AdminRepositoryBean().roboczaShowAllProducts());
        writer.println("</body></html>");
    }
}


