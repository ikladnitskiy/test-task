package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Сущность Аккаунт.
 */
public class Account implements Serializable {

  private String accountName;
  private String userName;
  private String userLastName;

  public Account() {
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Account)) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(accountName, account.accountName) &&
        Objects.equals(userName, account.userName) &&
        Objects.equals(userLastName, account.userLastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, userName, userLastName);
  }

  @Override
  public String toString() {
    return "Account{" +
        "accountName='" + accountName + '\'' +
        ", userName='" + userName + '\'' +
        ", userLastName='" + userLastName + '\'' +
        '}';
  }
}
