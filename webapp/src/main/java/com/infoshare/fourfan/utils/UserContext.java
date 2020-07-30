package com.infoshare.fourfan.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class UserContext {

    public static void setUserContext(HttpServletRequest req, Map<String, Object> dataModel) {
        HttpSession session = req.getSession();
        String loggedInUser = (String) session.getAttribute("email");
        Boolean isAdminLoggedUser = (Boolean) session.getAttribute("isAdmin");
        dataModel.put("email", loggedInUser);
        dataModel.put("isAdmin", isAdminLoggedUser);
    }

    public static Boolean requireUserContext(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> dataModel) throws IOException {
        HttpSession session = req.getSession();
        String loggedInUser = (String) session.getAttribute("email");
        if (loggedInUser == null) {
            resp.sendRedirect("/loginUser");
            return false;
        }
        Boolean isAdminLoggedUser = (Boolean) session.getAttribute("isAdmin");
        dataModel.put("email", loggedInUser);
        dataModel.put("isAdmin", isAdminLoggedUser);
        return true;
    }

    public static Boolean requireAdminContext(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> dataModel) throws IOException {
        HttpSession session = req.getSession();
        String loggedInUser = (String) session.getAttribute("email");
        Boolean isAdminLoggedUser = (Boolean) session.getAttribute("isAdmin");
        if (loggedInUser == null || !isAdminLoggedUser) {
            resp.sendRedirect("/loginUser");
            return false;
        }
        dataModel.put("email", loggedInUser);
        dataModel.put("isAdmin", isAdminLoggedUser);
        return true;
    }
}
