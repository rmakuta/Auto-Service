package pl.makuta.controller.report;

import pl.makuta.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reportOperatingProfits")
public class ReportOperatingProfits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        req.setAttribute("operatingProfit", new OrderDao().findOperatingProfits(req.getParameter("start"), req.getParameter("finish")));
        req.getRequestDispatcher("/report/reportOperatingProfits.jsp").forward(req, resp);
    }
}
