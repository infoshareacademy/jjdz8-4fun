package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.access.User;
import com.isa.usersengine.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/find-user-by-email")
public class FindUserByIdServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FindUserByIdServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        com.isa.usersengine.service.UserService userService=new UserService();
        User user = userService.findByEmail(idParam);
        PrintWriter printWriter = resp.

    }
}

