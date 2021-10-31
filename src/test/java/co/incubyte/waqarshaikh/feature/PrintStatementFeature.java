package co.incubyte.waqarshaikh.feature;

import static org.mockito.Mockito.verify;

import co.incubyte.waqarshaikh.Account;
import co.incubyte.waqarshaikh.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {

  @Mock
  Console console;
  private Account account;

  @BeforeEach
  public void setUp() {
    account = new Account();
  }

  @Test
  void print_statement_containing_al_transaction() {
    account.deposit(1000);
    account.withdraw(100);
    account.deposit(500);

    account.printStatement();

    verify(console).printLine("DATE | AMOUNT | BALANCE");
    verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }
}
