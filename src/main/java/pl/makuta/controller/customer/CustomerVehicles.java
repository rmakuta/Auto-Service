package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;
import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Customer;
import pl.makuta.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerVehicles")
public class CustomerVehicles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        VehicleDao vehicleDao = new VehicleDao();
        req.setAttribute("vehicles", vehicleDao.findAllVehiclesByCustomerId(id));
        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customer", customerDao.read(id));
        req.setAttribute("customerDao", customerDao);
        req.getRequestDispatcher("/customer/customerVehicles.jsp").forward(req, resp);
    }
}
