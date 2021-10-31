package co.incubyte.waqarshaikh;

public class Account {

  private TransactionRepository transactionRepo;

  public Account(TransactionRepository transactionRepo) {
    this.transactionRepo = transactionRepo;
  }

  public void deposit(int amount) {
    this.transactionRepo.addDeposit(amount);
  }

  public void withdraw(int amount) {
    this.transactionRepo.addWithdrawal(amount);
  }

  public void printStatement() {
    throw new UnsupportedOperationException();
  }
}
