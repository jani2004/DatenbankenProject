package org.example.datenbankenprojekt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.datenbankenprojekt.dao.EmployeeDAO;
import org.example.datenbankenprojekt.model.Employee;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.findAll();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/employeeList.jsp").forward(request, response);
    }
}