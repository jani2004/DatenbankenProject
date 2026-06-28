package org.example.datenbankenprojekt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.datenbankenprojekt.dao.EmployeeDAO;
import org.example.datenbankenprojekt.model.Employee;

import java.io.IOException;

@WebServlet("/searchEmployee")
public class EmployeeSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int socnum = Integer.parseInt(request.getParameter("socnum"));

            EmployeeDAO dao = new EmployeeDAO();

            Employee employee = dao.findBySocNum(socnum);

            HttpSession session = request.getSession();

            session.setAttribute("socnum", socnum);

            request.setAttribute("employee", employee);

            request.getRequestDispatcher("/employeeResult.jsp").forward(request, response);

        } catch(Exception e) {

            throw new ServletException(e);
        }
    }
}