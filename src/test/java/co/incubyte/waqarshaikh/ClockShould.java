package co.incubyte.waqarshaikh;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ClockShould {

  @Test
  public void return_todays_data_in_dd_MM_yyy_format() {
    Clock clock = new TestableClock();

    String date = clock.todayAsString();

    assertThat(date).isEqualTo("31/10/2021");
  }

  private class TestableClock extends Clock {

    @Override
    protected LocalDate today() {
      return LocalDate.of(2021, 10, 31);
    }
  }
}