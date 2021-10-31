package co.incubyte.waqarshaikh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryShould {

  public static final String TODAY = "31/10/2021";
  private TransactionRepository transactionRepo;
  @Mock
  private Clock clock;

  @BeforeEach
  public void setUp() {
    given(clock.todayAsString()).willReturn(TODAY);
    transactionRepo = new TransactionRepository();
  }

  @Test
  public void create_and_store_a_deposit_transaction() {
    transactionRepo.addDeposit(100);

    List<Transaction> transactions = transactionRepo.allTransactions();

    assertThat(transactions.size()).isEqualTo(1);
    assertThat(transactions.get(0)).isEqualTo(transactions(TODAY, 100));
  }

  @Test
  public void create_and_store_a_withdrawal_transaction() {
    transactionRepo.addWithdrawal(100);

    List<Transaction> transactions = transactionRepo.allTransactions();

    assertThat(transactions.size()).isEqualTo(1);
    assertThat(transactions.get(0)).isEqualTo(transactions(TODAY, -100));
  }

  private Transaction transactions(String date, int amount) {
    return new Transaction(date, amount);
  }
}