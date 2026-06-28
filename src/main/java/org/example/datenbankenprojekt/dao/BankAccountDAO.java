package org.example.datenbankenprojekt.dao;

import org.example.datenbankenprojekt.database.DBConnection;
import org.example.datenbankenprojekt.model.BankAccount;

import java.sql.*;

public class BankAccountDAO {

    public BankAccount findAccount(int bankNum, int accountNum) {

        String sql = "SELECT * " + "FROM BANK_ACCOUNT " + "WHERE BankNum=? " + "AND AccountNum=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, bankNum);
            stmt.setInt(2, accountNum);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new BankAccount(rs.getInt("BankNum"), rs.getInt("AccountNum"), rs.getInt("Balance"));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(BankAccount account){

        String sql = "INSERT INTO BANK_ACCOUNT VALUES(?,?,?)";

        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, account.getBankNum());
            stmt.setInt(2, account.getAccountNum());
            stmt.setInt(3, account.getBalance());

            stmt.executeUpdate();
            return true;

        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertEmployeeAccount(int bankNum, int accountNum, int socNum) {

        String sql = "INSERT INTO BANK_ACCOUNT_BELONGS_TO_EMPLOYEE VALUES (?, ?, ?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, bankNum);
            stmt.setInt(2, accountNum);
            stmt.setInt(3, socNum);

            stmt.executeUpdate();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
