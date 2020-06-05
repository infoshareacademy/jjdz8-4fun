package com.infoshare.fourfan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/log-out")
public class AdminLogutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html,charset=UTF8");

        HttpSession session = req.getSession();
        session.invalidate();

        resp.sendRedirect("../../page-after-logout.jsp");
    }
}
