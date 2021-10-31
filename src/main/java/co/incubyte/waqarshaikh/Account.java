package co.incubyte.waqarshaikh;

public class Account {

  private TransactionRepository transactionRepo;
  private StatementPrinter statementPrinter;

  public Account(TransactionRepository transactionRepo,
      StatementPrinter statementPrinter) {
    this.transactionRepo = transactionRepo;
    this.statementPrinter = statementPrinter;
  }

  public void deposit(int amount) {
    this.transactionRepo.addDeposit(amount);
  }

  public void withdraw(int amount) {
    this.transactionRepo.addWithdrawal(amount);
  }

  public void printStatement() {
    this.statementPrinter.print(this.transactionRepo.allTransactions());
  }
}
