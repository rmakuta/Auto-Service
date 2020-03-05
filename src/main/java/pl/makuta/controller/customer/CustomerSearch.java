package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerSearch")
public class CustomerSearch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customers", customerDao.findCustomerBySurname(req.getParameter("surname")));
        req.getRequestDispatcher("/customer/customerSearch.jsp").forward(req, resp);
    }
}
