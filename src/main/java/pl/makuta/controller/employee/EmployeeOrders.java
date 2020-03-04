package pl.makuta.controller.employee;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeOrders")
public class EmployeeOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        OrderDao orderDao = new OrderDao();
        req.setAttribute("orders", orderDao.findAllOrdersByEmployeeId(id));
        EmployeeDao employeeDao = new EmployeeDao();
        req.setAttribute("employee", employeeDao.read(id));
        req.setAttribute("employeeDao", new EmployeeDao());
        req.setAttribute("vehicleDao", new VehicleDao());
        req.getRequestDispatcher("/employee/employeeOrders.jsp").forward(req, resp);
    }
}
