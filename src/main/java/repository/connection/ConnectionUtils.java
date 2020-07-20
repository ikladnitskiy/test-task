package repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Утилитный класс для работы с Connection.
 */
public class ConnectionUtils {

  private static final String HOST = "jdbc:postgresql://localhost:5432/";
  private static final String DB_NAME = "accounts";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "postgres";

  /**
   * Возвращает новый Connection.
   */
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    String url = HOST + DB_NAME;
    return DriverManager.getConnection(url, USERNAME, PASSWORD);
  }
}
