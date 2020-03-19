package pl.makuta.controller.report;

import pl.makuta.dao.EmployeeDao;
import pl.makuta.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/reportManHours")
public class ReportManHours extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        EmployeeDao employeeDao = new EmployeeDao();
        Map<String, Integer> mapNew = new HashMap<>();
        for(Map.Entry<Integer, Integer> map: new OrderDao().findTest(req.getParameter("start"),
                req.getParameter("finish")).entrySet()){
            int i = map.getKey();
            String name = employeeDao.read(i).getName();
            String surname = employeeDao.read(i).getSurname();
            mapNew.put(name + " " + surname, map.getValue());
        }
        req.setAttribute("mapNew", mapNew);
        req.getRequestDispatcher("/report/reportManHours.jsp").forward(req, resp);
    }
}
