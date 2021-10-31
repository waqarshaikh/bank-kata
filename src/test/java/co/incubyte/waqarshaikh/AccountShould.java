package com.waqar;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import co.incubyte.waqarshaikh.Account;
import co.incubyte.waqarshaikh.StatementPrinter;
import co.incubyte.waqarshaikh.Transaction;
import co.incubyte.waqarshaikh.TransactionRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountShould {

  private Account account;
  @Mock
  private TransactionRepository transactionRepo;
  @Mock
  private StatementPrinter statementPrinter;

  @BeforeEach
  void setup() {
    account = new Account(transactionRepo, statementPrinter);
  }

  @Test
  public void store_a_deposit_transaction() {
    account.deposit(100);
    verify(transactionRepo).addDeposit(100);
  }

  @Test
  public void store_a_withdraw_transaction() {
    account.withdraw(500);
    verify(transactionRepo).addWithdrawal(500);
  }

  @Test
  public void print_a_statement() {
    List<Transaction> transactions = asList(new Transaction());

    given(transactionRepo.allTransactions()).willReturn(transactions);

    account.printStatement();
    verify(statementPrinter).print(transactions);
  }
}
