package config;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/supermarket";
        String username = "Onur";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;

    }
}
