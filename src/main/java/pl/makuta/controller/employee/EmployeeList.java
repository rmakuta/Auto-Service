package pl.makuta.controller.employee;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeList")
public class EmployeeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
//        List<Employee> employees = employeeDao.findAll();
//        req.setAttribute("employees", employees);
        Employee employee = employeeDao.read(1);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
    }
}
