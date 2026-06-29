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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AccountListServlet", value = "/AccountListServlet")
public class AccountListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, String>> accountList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT ba.BankNum, ba.AccountNum, ba.Balance, p.FirstName, p.LastName " +
                    "FROM BANK_ACCOUNT ba " +
                    "LEFT JOIN BANK_ACCOUNT_BELONGS_TO_EMPLOYEE babe ON ba.BankNum = babe.BankNum AND ba.AccountNum = babe.AccountNum " +
                    "LEFT JOIN PERSON p ON babe.SocNum = p.SocNum";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, String> account = new HashMap<>();
                account.put("bankNum", String.valueOf(rs.getInt("BankNum")));
                account.put("accountNum", String.valueOf(rs.getInt("AccountNum")));
                account.put("balance", String.valueOf(rs.getInt("Balance")));

                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String owner = (firstName != null && lastName != null) ? firstName + " " + lastName : "Unassigned";
                account.put("owner", owner);

                accountList.add(account);
            }

            request.setAttribute("accounts", accountList);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to load accounts.");
        }

        request.getRequestDispatcher("accountList.jsp").forward(request, response);
    }
}