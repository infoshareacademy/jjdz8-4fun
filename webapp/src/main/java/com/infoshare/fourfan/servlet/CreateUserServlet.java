package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.freemarker.TemplateProvider;
import com.infoshare.fourfan.service.UserServiceJson;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(com.infoshare.fourfan.servlet.CreateUserServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserServiceJson userServiceJson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "createUser.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        if(password.equals(confirmPassword)) {
            User user = new User(email, password, name, surName, phoneNumber);
            userServiceJson.createNewUser(user);
            resp.sendRedirect("/confirmNewUser");
        } else {
            resp.sendRedirect("/createUser");
        }
    }
}
