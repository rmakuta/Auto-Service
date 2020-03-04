package pl.makuta.controller.order;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Employee;
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

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findAll();
        req.setAttribute("orders", orders);
        EmployeeDao employeeDao = new EmployeeDao();
        req.setAttribute("employeeDao", employeeDao);
        VehicleDao vehicleDao = new VehicleDao();
        req.setAttribute("vehicleDao", vehicleDao);
        req.getRequestDispatcher("/order/orderList.jsp").forward(req, resp);
    }
}
