package co.incubyte.waqarshaikh;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

  private final Clock clock;
  private List<Transaction> transactions = new ArrayList<>();

  public TransactionRepository(Clock clock) {
    this.clock = clock;
  }

  public void addDeposit(int amount) {
    final Transaction deposit = new Transaction(clock.todayAsString(), amount);
    transactions.add(deposit);
  }

  public void addWithdrawal(int amount) {
    final Transaction withdrawal = new Transaction(clock.todayAsString(), -amount);
    transactions.add(withdrawal);
  }

  public List<Transaction> allTransactions() {
    return unmodifiableList(transactions);
  }
}
