package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;
import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Order;
import pl.makuta.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customerOrders")
public class CustomerOreders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> customerVehicles = vehicleDao.findAllVehiclesByCustomerId(Integer.parseInt(req.getParameter("id")));
        OrderDao orderDao = new OrderDao();
        List<Order> orders = new ArrayList<>();
        for (Vehicle customerVehicle : customerVehicles) {
            List<Order> orderList = orderDao.findAllOrdersByVehicleId(customerVehicle.getId());
            for (Order order : orderList) {
                orders.add(order);
            }
        }
        req.setAttribute("orders", orders);
        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customer", customerDao.read(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("vehicleDao", vehicleDao);
        EmployeeDao employeeDao = new EmployeeDao();
        req.setAttribute("employeeDao", employeeDao);
        req.getRequestDispatcher("/customer/customerOrders.jsp").forward(req, resp);
    }
}
