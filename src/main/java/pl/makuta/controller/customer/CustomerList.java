package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerList")
public class CustomerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customers", customerDao.findAll());
        req.getRequestDispatcher("/customer/customerList.jsp").forward(req, resp);
    }
}
