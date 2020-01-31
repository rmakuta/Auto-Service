package pl.makuta.controller;

import pl.makuta.dao.OrderDao;
import pl.makuta.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
