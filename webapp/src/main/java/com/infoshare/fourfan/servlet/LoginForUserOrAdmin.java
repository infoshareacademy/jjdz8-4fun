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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/loginUser")
public class LoginForUserOrAdmin extends HttpServlet {

    private static final Logger logger
            = Logger.getLogger(com.infoshare.fourfan.servlet.CreateUserServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserServiceJson userServiceJson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "loginUser.ftlh");
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
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HashMap<String, Object> dataModel = new HashMap<>();
        Template template;

        Optional<User> userLoginInput = userServiceJson.findByEmailAndPassword(email, password);

        if (userLoginInput.isEmpty()) {
            resp.sendRedirect("/loginUser");
            return;
        }
        session.setAttribute("name", userLoginInput.get().getName());
        session.setAttribute("surName", userLoginInput.get().getSurName());
        session.setAttribute("email", userLoginInput.get().getEmail());
        session.setAttribute("phoneNumber", userLoginInput.get().getPhoneNumber());
        session.setAttribute("password", userLoginInput.get().getPassword());

        if (!userLoginInput.get().isAdmin()) {
            //TODO: podać przekierowanie na poprawny template dla usera
            dataModel.put("name", userLoginInput.get().getName());
            template = templateProvider.getTemplate(getServletContext(), "about.ftlh");
        } else {
            //TODO: podać przekierowanie na poprawny template dla admina
            dataModel.put("name", userLoginInput.get().getName());
            template = templateProvider.getTemplate(getServletContext(), "addProduct.ftlh");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
