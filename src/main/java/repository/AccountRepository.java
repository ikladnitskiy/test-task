package repository;

import java.sql.SQLException;
import model.Account;

/**
 * Интерфейс репозитория для операций с сущностью Account.
 */
public interface AccountRepository {

  /**
   * Возвращает сущность Account.
   *
   * @param accountName - имя Аккаунта
   */
  Account getAccount(String accountName) throws SQLException, ClassNotFoundException;

  /**
   * Обновляет запись в БД.
   *
   * @param accountName     - имя обновляемого Аккаунта
   * @param updatedUserName - новое имя пользователя
   */
  int editUserName(String accountName, String updatedUserName)
      throws ClassNotFoundException, SQLException;
}
