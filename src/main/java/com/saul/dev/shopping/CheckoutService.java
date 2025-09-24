package com.saul.dev.shopping;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

  public List<String> checkout(List<String> items) {

    return items.stream().filter(item -> item.equals("apple") || item.equals("orange")).toList();

  }

  public BigDecimal total(List<String> checkedOutItems) {

    return checkedOutItems.stream().map(item -> {
      if (item.equals("apple")) {
        return Items.APPLE.getPrice();
      } else {
        return Items.ORANGE.getPrice();
      }
    }).reduce(BigDecimal.ZERO, BigDecimal::add);


  }
}
