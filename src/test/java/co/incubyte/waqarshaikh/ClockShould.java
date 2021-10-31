package co.incubyte.waqarshaikh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ClockShould {

  @Test
  public void return_todays_data_in_dd_MM_yyy_format() {
    Clock clock = new Clock();

    String date = clock.todayAsString();

    assertThat(date).isEqualTo("31/10/2021");
  }

}