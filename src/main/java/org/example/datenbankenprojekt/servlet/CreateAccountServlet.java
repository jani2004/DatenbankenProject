package org.example.datenbankenprojekt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.datenbankenprojekt.dao.BankAccountDAO;
import org.example.datenbankenprojekt.model.BankAccount;

import java.io.IOException;


@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankAccount account = new BankAccount(
                        Integer.parseInt(request.getParameter("bankNum")),
                        Integer.parseInt(request.getParameter("accountNum")),
                        Integer.parseInt(request.getParameter("balance")));

        HttpSession session = request.getSession();
        Integer socnum = (Integer) session.getAttribute("socnum");

        System.out.println("SESSION SOCNUM: " + socnum);

        BankAccountDAO dao = new BankAccountDAO();

        boolean success = dao.insert(account);

        if (success){
            dao.insertEmployeeAccount(account.getBankNum(), account.getAccountNum(), socnum);
        }

        request.setAttribute("success", success);
        request.getRequestDispatcher("/accountCreated.jsp").forward(request, response);
    }
}
