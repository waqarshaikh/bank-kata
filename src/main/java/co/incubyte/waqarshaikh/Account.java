package co.incubyte.waqarshaikh;

public class Account {

  private TransactionRepository transactionRepo;

  public Account(TransactionRepository transactionRepo) {
    this.transactionRepo = transactionRepo;
  }

  public void deposit(int amount) {
    throw new UnsupportedOperationException();
  }

  public void withdraw(int amount) {
    throw new UnsupportedOperationException();
  }

  public void printStatement() {
    throw new UnsupportedOperationException();
  }
}
