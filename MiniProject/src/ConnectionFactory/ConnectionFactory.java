package ConnectionFactory;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/miniproject";

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProperties = new Properties();
            connectionProperties.put("user", USERNAME);
            connectionProperties.put("password", PASSWORD);
            con = DriverManager.getConnection(URL, connectionProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
