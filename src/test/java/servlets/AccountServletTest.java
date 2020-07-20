package servlets;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.AccountService;

public class AccountServletTest {

  @Mock
  public AccountService mockService;

  @Mock
  public HttpServletRequest request;

  @Mock
  public HttpServletResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    Account account = new Account();
    account.setAccountName("TestAccountName");
    account.setUserName("TestUserName");
    account.setUserLastName("TestLastName");

    when(mockService.getAccount(anyString())).thenReturn(account);
  }

  @Test
  public void testDoGet() throws ServletException, IOException {
    String expectedJson = "{"
        + "\"accountName\":\"TestAccountName\","
        + "\"userName\":\"TestUserName\","
        + "\"userLastName\":\"TestLastName\""
        + "}";

    when(request.getParameter("accountName")).thenReturn("TestAccountName");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(writer);

    AccountServlet servlet = new AccountServlet();
    servlet.service = mockService;
    servlet.doGet(request, response);
    assertTrue(stringWriter.toString().contains(expectedJson));
  }
}