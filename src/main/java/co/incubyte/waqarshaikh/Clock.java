package co.incubyte.waqarshaikh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

  public String todayAsString() {
    LocalDate today = LocalDate.now();
    return today.format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
  }
}
