package pl.makuta.controller.customer;

import pl.makuta.dao.CustomerDao;
import pl.makuta.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerEdit")
public class CustomerEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        req.setAttribute("customer", customerDao.read(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/customer/customerEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(req.getParameter("id")));
        customer.setName(req.getParameter("name"));
        customer.setSurname(req.getParameter("surname"));
        if(!req.getParameter("birthDate").isEmpty()){
            customer.setBirthDate(req.getParameter("birthDate"));
        }
        customerDao.update(customer);
        resp.sendRedirect("/customerList");
    }
}
