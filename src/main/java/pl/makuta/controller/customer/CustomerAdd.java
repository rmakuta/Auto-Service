package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;
import pl.makuta.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerAdd")
public class CustomerAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setSurname(req.getParameter("surname"));
        if(!req.getParameter("birthDate").isEmpty()){
            customer.setBirthDate(req.getParameter("birthDate"));
        }
        customerDao.create(customer);
        resp.sendRedirect("/customerList");
    }
}
