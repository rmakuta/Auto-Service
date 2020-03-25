package pl.makuta.controller.order;

import pl.makuta.dao.CustomerDao;
import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderList")
public class OrderList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        req.setAttribute("orders", new OrderDao().findAll());
        req.setAttribute("employeeDao", new EmployeeDao());
        req.setAttribute("vehicleDao", new VehicleDao());
        req.setAttribute("customerDao", new CustomerDao());
        req.getRequestDispatcher("/order/orderList.jsp").forward(req, resp);
    }
}
