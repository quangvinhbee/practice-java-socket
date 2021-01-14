/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_UDP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lamqu
 */
public class ConnectionDTB {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String name = "sa";
        String pass = "A1t2o300";
        String url = "jdbc:sqlserver://localhost:1434;databaseName=LTM;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, name, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
