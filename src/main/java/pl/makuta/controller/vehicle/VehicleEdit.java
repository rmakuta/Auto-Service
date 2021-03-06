package pl.makuta.controller.vehicle;

import pl.makuta.dao.CustomerDao;
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

@WebServlet("/vehicleEdit")
public class VehicleEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        VehicleDao vehicleDao = new VehicleDao();
        req.setAttribute("vehicle", vehicleDao.read(Integer.parseInt(req.getParameter("id"))));

        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customers", customerDao.findAll());
        req.getRequestDispatcher("/vehicle/vehicleEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(Integer.parseInt(req.getParameter("id")));
        vehicle.setModel(req.getParameter("model"));
        vehicle.setBrand(req.getParameter("brand"));
        if(!req.getParameter("birth").isEmpty()){
            vehicle.setBirth(req.getParameter("birth"));
        }
        vehicle.setRegNumber(req.getParameter("regNumber"));
        if(!req.getParameter("nextServiceDate").isEmpty()){
            vehicle.setNextServiceDate(req.getParameter("nextServiceDate"));
        }
        vehicle.setCustomerId(Integer.parseInt(req.getParameter("customerId")));
        vehicleDao.update(vehicle);
        resp.sendRedirect("/vehicleList");
    }
}
