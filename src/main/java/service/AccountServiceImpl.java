package service;

import java.sql.SQLException;
import model.Account;
import repository.AccountRepository;
import repository.AccountRepositoryImpl;

/**
 * Реализация интерфейса AccountService для операций с сущностью Account.
 *
 * @see AccountService
 */
public class AccountServiceImpl implements AccountService {

  private AccountRepository repository;

  public AccountServiceImpl() {
    this.repository = new AccountRepositoryImpl();
  }

  public AccountRepository getRepository() {
    return repository;
  }

  public void setRepository(AccountRepository repository) {
    this.repository = repository;
  }

  public Account getAccount(String accountName) throws SQLException, ClassNotFoundException {
    return repository.getAccount(accountName);
  }

  public int editUserName(String accountName, String updatedUserName)
      throws SQLException, ClassNotFoundException {
      return repository.editUserName(accountName, updatedUserName);
  }
}
