import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private final String url = "jdbc:mysql://localhost/mediateca";
    Connection connection = null;

    public MysqlConnection() {
        try {
            connection = DriverManager.getConnection(url, "root", "Database$1");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        connection = null;
    }
}
