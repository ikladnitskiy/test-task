package service;

import java.sql.SQLException;
import model.Account;

/**
 * Интерфейс сервиса для операций с Account.
 */
public interface AccountService {

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
      throws SQLException, ClassNotFoundException;
}
