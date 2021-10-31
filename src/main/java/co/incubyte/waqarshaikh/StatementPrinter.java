package co.incubyte.waqarshaikh;

import static java.util.stream.Collectors.toCollection;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementPrinter {

  private DecimalFormat decimalFormater = new DecimalFormat("#.00");
  private Console console;

  public StatementPrinter(Console console) {
    this.console = console;
  }

  public void print(List<Transaction> transactions) {
    console.printLine("DATE | AMOUNT | BALANCE");

    printStatementLines(transactions);
  }

  private void printStatementLines(List<Transaction> transactions) {
    AtomicInteger runningBalance = new AtomicInteger(0);
    transactions.stream()
        .map(transaction -> statementLine(transaction, runningBalance))
        .collect(toCollection(LinkedList::new))
        .descendingIterator()
        .forEachRemaining(console::printLine);
  }

  private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
    return transaction.date() +
        " | " +
        decimalFormater.format(transaction.amount()) +
        " | " +
        decimalFormater.format(runningBalance.addAndGet(transaction.amount()));
  }
}
