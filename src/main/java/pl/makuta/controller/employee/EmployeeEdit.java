package pl.makuta.controller.employee;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeEdit")
public class EmployeeEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("employee", employee);
        System.out.println(employee.getName() + " " + employee.getSurname() + " " + employee.getPhoneNumber());
        req.getRequestDispatcher("/employee/employeeEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(req.getParameter("id")));
        employee.setName(req.getParameter("name"));
        employee.setSurname(req.getParameter("surname"));
        employee.setAddress(req.getParameter("address"));
        employee.setPhoneNumber(req.getParameter("phoneNumber"));
        employee.setNote(req.getParameter("note"));
        employee.setManHourCost(Double.parseDouble(req.getParameter("manHourCost")));
        employeeDao.update(employee);
        resp.sendRedirect("/employeeList");
    }
}
