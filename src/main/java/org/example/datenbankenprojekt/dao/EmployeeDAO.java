package org.example.datenbankenprojekt.dao;

import org.example.datenbankenprojekt.database.DBConnection;
import org.example.datenbankenprojekt.model.Employee;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class EmployeeDAO {

    public Employee findBySocNum(int socNum) throws Exception {

        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM PERSON p JOIN EMPLOYEE e ON p.SocNum=e.SocNum WHERE p.SocNum=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, socNum);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return new Employee(
                    rs.getInt("SocNum"),
                    rs.getInt("EmpNum"),
                    rs.getString("FirstName"),
                    rs.getString("LastName")
            );
        }
        return null;
    }

    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT p.SocNum, e.EmpNum, " + "p.FirstName, p.LastName " + "FROM EMPLOYEE e " + "JOIN PERSON p " + "ON e.SocNum = p.SocNum";
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while(rs.next()) {
                employees.add(
                        new Employee(
                                rs.getInt("SocNum"),
                                rs.getInt("EmpNum"),
                                rs.getString("FirstName"),
                                rs.getString("LastName")
                        )
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}