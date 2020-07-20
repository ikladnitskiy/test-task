package converter;

import model.Account;
import org.junit.Assert;
import org.junit.Test;

public class JsonConverterTest {

  @Test
  public void testToJsonAccountTrue() {
    String expected = "{"
        + "\"accountName\":\"TestAccountName\","
        + "\"userName\":\"TestUserName\","
        + "\"userLastName\":\"TestUserLastName\""
        + "}";

    Account account = new Account();
    account.setAccountName("TestAccountName");
    account.setUserName("TestUserName");
    account.setUserLastName("TestUserLastName");

    Assert.assertEquals(JsonConverter.toJson(account), expected);
  }
}