package pl.makuta.controller.vehicle;

import pl.makuta.dao.CustomerDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Customer;
import pl.makuta.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicleAdd")
public class VehicleAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customers", customerDao.findAll());
        req.getRequestDispatcher("/vehicle/vehicleAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(req.getParameter("model"));
        vehicle.setBrand(req.getParameter("brand"));
        vehicle.setBirth(Integer.parseInt(req.getParameter("birth")));
        vehicle.setRegNumber(req.getParameter("regNumber"));
        vehicle.setNextServiceDate(req.getParameter("nextServiceDate"));
        vehicle.setCustomerId(Integer.parseInt(req.getParameter("customerId")));
        vehicleDao.create(vehicle);
        resp.sendRedirect("/vehicleList");
    }
}
