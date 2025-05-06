package Test;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TenDatabase";
        String user = "sa";
        String password = "yourPassword";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
