package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import repository.connection.ConnectionUtils;

/**
 * Реализация интерфейса AccountRepository для операций с сущностью Account.
 *
 * @see AccountRepository
 */
public class AccountRepositoryImpl implements AccountRepository {

  public Account getAccount(String accountName) throws ClassNotFoundException, SQLException {
    String sql = "SELECT a.account_name, a.user_name, a.user_last_name FROM accounts a "
        + "WHERE a.account_name = ?";

    try (Connection conn = ConnectionUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql)) {
      pstm.setString(1, accountName);
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        String name = rs.getString("account_name");
        String userName = rs.getString("user_name");
        String userLastName = rs.getString("user_last_name");
        Account account = new Account();
        account.setAccountName(name);
        account.setUserName(userName);
        account.setUserLastName(userLastName);
        //log.info("Account with accountName=%s successfully find", accountName);
        return account;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int editUserName(String accountName, String updatedUserName)
      throws ClassNotFoundException, SQLException {
    String sql = "UPDATE accounts SET user_last_name = ? WHERE account_name = ?";

    try (Connection conn = ConnectionUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql)) {
      pstm.setString(1, updatedUserName);
      pstm.setString(2, accountName);
      int row = pstm.executeUpdate();
      //log.info("Account with accountName=%s successfully updated. Count updated rows=%d", accountName, row);
      return row;
    }
  }
}
