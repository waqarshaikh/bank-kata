package co.incubyte.waqarshaikh;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

  private static final List<Transaction> NO_TRANSACTIONS = emptyList();
  public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
  @Mock
  private Console console;
  private StatementPrinter statementPrinter;

  @BeforeEach
  public void setup() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  public void always_print_header() {
    statementPrinter.print(NO_TRANSACTIONS);
    verify(console).printLine(STATEMENT_HEADER);
  }

  @Test
  public void print_transactions_in_reverse_chronological_order() {
    List<Transaction> transactions = transactionsContaining(
        deposit("01/04/2014", 1000),
        withdrawal("02/04/2014", 100),
        deposit("10/04/2014", 500)
    );
    statementPrinter.print(transactions);

    InOrder inOrder = inOrder(console);

    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }

  private List<Transaction> transactionsContaining(Transaction... transactions) {
    return asList(transactions);
  }

  private Transaction withdrawal(String date, int amount) {
    return new Transaction(date, -amount);
  }

  private Transaction deposit(String date, int amount) {
    return new Transaction(date, amount);
  }

}