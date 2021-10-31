package co.incubyte.waqarshaikh;

public class Application {

    public static void main(String[] args) {
        Clock clock = new Clock();
        TransactionRepository transactionRepo = new TransactionRepository(clock);
        Console console = new Console();
        StatementPrinter statementPrinter = new StatementPrinter(console);
        Account account = new Account(transactionRepo, statementPrinter);

        account.deposit(1000);
        account.withdraw(400);
        account.deposit(1000);

        account.printStatement();
    }
}
