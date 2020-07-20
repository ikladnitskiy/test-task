package converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import model.Account;

/**
 * Конвертер объектов, передаваемых клиенту.
 */
public class JsonConverter {

  public static String toJson(Account account) {
    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(account);
    } catch (IOException ex) {
      //log.info("Ошибка при конвертации объекта: " + account);
    }
    return json;
  }
}
