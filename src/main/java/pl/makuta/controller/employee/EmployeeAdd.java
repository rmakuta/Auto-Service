package pl.makuta.controller.employee;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeAdd")
public class EmployeeAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setSurname(req.getParameter("surname"));
        employee.setAddress(req.getParameter("address"));
        employee.setPhoneNumber(req.getParameter("phoneNumber"));
        employee.setNote(req.getParameter("note"));
        employee.setManHourCost(Double.parseDouble(req.getParameter("manHourCost")));
        employeeDao.create(employee);
        resp.sendRedirect("/employeeList");
    }
}
