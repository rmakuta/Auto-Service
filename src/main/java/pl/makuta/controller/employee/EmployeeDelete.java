package pl.makuta.controller.employee;

import pl.makuta.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeDelete")
public class EmployeeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/employeeList");
    }
}
