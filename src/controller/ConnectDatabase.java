/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THUY
 */
public class ConnectDatabase {

    private static Connection conn;

    public static Connection getData() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=OrderManagement;username=sa;password=1234$");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return conn;
    }

}
