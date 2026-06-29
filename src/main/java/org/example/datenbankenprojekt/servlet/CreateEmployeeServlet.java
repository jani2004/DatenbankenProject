package org.example.datenbankenprojekt.servlet;

import org.example.datenbankenprojekt.database.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "CreateEmployeeServlet", value = "/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int socNum = Integer.parseInt(request.getParameter("socNum"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String postCode = request.getParameter("postCode");
        String place = request.getParameter("place");
        String street = request.getParameter("street");
        int houseNum = Integer.parseInt(request.getParameter("houseNum"));

        int empNum = Integer.parseInt(request.getParameter("empNum"));

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            String personSql = "INSERT INTO PERSON (SocNum, FirstName, LastName, PostCode, Place, Street, HouseNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement personStmt = conn.prepareStatement(personSql);
            personStmt.setInt(1, socNum);
            personStmt.setString(2, firstName);
            personStmt.setString(3, lastName);
            personStmt.setString(4, postCode);
            personStmt.setString(5, place);
            personStmt.setString(6, street);
            personStmt.setInt(7, houseNum);
            personStmt.executeUpdate();

            String employeeSql = "INSERT INTO EMPLOYEE (SocNum, EmpNum) VALUES (?, ?)";
            PreparedStatement empStmt = conn.prepareStatement(employeeSql);
            empStmt.setInt(1, socNum);
            empStmt.setInt(2, empNum);
            empStmt.executeUpdate();

            conn.commit();

            request.setAttribute("message", "Success! Employee " + firstName + " " + lastName + " was added to the database.");

        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            request.setAttribute("message", "Error adding employee. It is possible that Social Security Number or Employee Number already exists.");
        } finally {
            request.getRequestDispatcher("employeeCreate.jsp").forward(request, response);
        }
    }
}