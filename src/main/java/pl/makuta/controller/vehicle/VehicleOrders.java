package pl.makuta.controller.vehicle;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;
import pl.makuta.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicleOrders")
public class VehicleOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        OrderDao orderDao = new OrderDao();
        req.setAttribute("orders", orderDao.findAllOrdersByVehicleId(id));
        VehicleDao vehicleDao = new VehicleDao();
        req.setAttribute("vehicle", vehicleDao.read(id));
        req.setAttribute("vehicleDao", vehicleDao);
        req.setAttribute("employeeDao", new EmployeeDao());
        req.getRequestDispatcher("/vehicle/vehicleOrders.jsp").forward(req, resp);
    }
}
