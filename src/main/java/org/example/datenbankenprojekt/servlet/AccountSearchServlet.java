package org.example.datenbankenprojekt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.datenbankenprojekt.dao.BankAccountDAO;
import org.example.datenbankenprojekt.model.BankAccount;

import java.io.IOException;

@WebServlet("/searchAccount")
public class AccountSearchServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int bankNum = Integer.parseInt(request.getParameter("bankNum"));
            int accountNum = Integer.parseInt(request.getParameter("accountNum"));

            BankAccountDAO dao = new BankAccountDAO();

            BankAccount account = dao.findAccount(bankNum, accountNum);

            request.setAttribute("account", account);

            request.getRequestDispatcher("/accountResult.jsp").forward(request, response);
        }
    }

