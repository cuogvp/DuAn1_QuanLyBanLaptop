/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dangc
 */
public class JdbcUltil {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String user = "sa", pass = "123456",
                        url = "jdbc:sqlserver://localhost:1433;databaseName=duAn1_laptop;"
                        + "encrypt=true;trustServerCertificate=true";
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
        
    }
    }
 
