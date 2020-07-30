package com.infoshare.fourfan.servlet;

import com.infoshare.fourfan.dao.ShopDao;
import com.infoshare.fourfan.dto.ShopDto;
import com.infoshare.fourfan.freemarker.TemplateProvider;
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
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/findShopById")
public class FindShopByIdServlet extends HttpServlet {

    @Inject
    private ShopDao shopDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger logger = Logger.getLogger(FindShopByIdServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "findShopById.ftlh");
        PrintWriter printWriter = resp.getWriter();
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<ShopDto> db_shop = shopDao.findShopIdDto(Integer.parseInt(idParam));

        Map<String, Object> dataModel = new HashMap<>();
        if (db_shop.isPresent()){
            dataModel.put("shop", db_shop.get());
            dataModel.put("shopId", db_shop.get().getId());
        } else {
            dataModel.put("errorMessage", "Product has not been found.");
        }
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
