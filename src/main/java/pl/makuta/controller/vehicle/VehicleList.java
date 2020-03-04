package pl.makuta.controller.vehicle;

import pl.makuta.dao.CustomerDao;
import pl.makuta.dao.VehicleDao;
import pl.makuta.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicleList")
public class VehicleList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicles = vehicleDao.findAll();
        req.setAttribute("vehicles", vehicles);
        req.setAttribute("customerDao", new CustomerDao());
        req.getRequestDispatcher("/vehicle/vehicleList.jsp").forward(req, resp);
    }
}
