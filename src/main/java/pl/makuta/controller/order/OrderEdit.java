package pl.makuta.controller.order;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Employee;
import pl.makuta.model.Order;
import pl.makuta.model.Status;
import pl.makuta.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderEdit")
public class OrderEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        OrderDao orderDao = new OrderDao();
        Order order = orderDao.read(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("order", order);

        req.setAttribute("statuses", Status.values());

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();
        req.setAttribute("employees", employees);

        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicles = vehicleDao.findAll();
        req.setAttribute("vehicles", vehicles);

        req.getRequestDispatcher("/order/orderEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        OrderDao orderDao = new OrderDao();
        Order order = new Order();
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(Integer.parseInt(req.getParameter("employeeId")));
        order.setId(Integer.parseInt(req.getParameter("id")));
        order.setAddDate(req.getParameter("addDate"));
        if(!req.getParameter("repairPlannedDate").isEmpty()){
            order.setRepairPlannedDate(req.getParameter("repairPlannedDate"));
        }
        if(!req.getParameter("repairDate").isEmpty()){
            order.setRepairDate(req.getParameter("repairDate"));
        }
        order.setEmployeeId(Integer.parseInt(req.getParameter("employeeId")));
        order.setProblemDescription(req.getParameter("problemDescription"));
        order.setRepairDescription(req.getParameter("repairDescription"));
        order.setStatus(Status.valueOf(req.getParameter("status")));
        order.setVehicleId(Integer.parseInt(req.getParameter("vehicleId")));
        order.setCarPartsCost(Double.parseDouble(req.getParameter("carPartsCost")));
        order.setManHourCost(employee.getManHourCost());
        order.setManHourQuantity(Integer.parseInt(req.getParameter("manHourQuantity")));
        orderDao.update(order);
        resp.sendRedirect("/orderList");
    }
}
