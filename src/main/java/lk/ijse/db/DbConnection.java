package lk.ijse.db;

import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Megan_Project",
                "root",
                "Omesh1106");
    }
    public static DbConnection getInstance() throws SQLException {

        return ( null == dbConnection) ? dbConnection = new DbConnection() : dbConnection;
    }
    public Connection getConnection() {
        return connection;
    }
}
