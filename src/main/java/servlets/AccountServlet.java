package servlets;

import static converter.JsonConverter.toJson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Сервлет для действий с Account.
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

  public AccountService service;

  @Override
  public void init() throws ServletException {
    this.service = new AccountServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String accountName = req.getParameter("accountName");
    Account account = null;
    try {
      account = service.getAccount(accountName);
    } catch (ClassNotFoundException | SQLException ex) {
      //log.info("Error in method getAccount: %s", ex);
    }
    if (account == null) {
      resp.sendError(204, String.format("Account with name %s not found", accountName));
    }
    resp.setContentType("application/json");
    PrintWriter writer = resp.getWriter();
    writer.println(toJson(account));
    resp.setStatus(200);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String accountName = req.getParameter("accountName");
    String lastName = req.getParameter("userLastName");
    int rows = 0;
    try {
      rows = service.editUserName(accountName, lastName);
    } catch (ClassNotFoundException | SQLException ex) {
      //log.info("Error in method editUserName: %s", ex);
    }
    if (rows <= 0) {
      resp.sendError(204, String.format("Account with name %s not found", accountName));
    }
    resp.setStatus(200);
  }
}
