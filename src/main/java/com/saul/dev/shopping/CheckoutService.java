package com.saul.dev.shopping;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

  public List<String> filterBasket(List<String> items) {

    return items.stream().filter(item -> item.equals("apple") || item.equals("orange")).toList();

  }

  public BigDecimal total(List<String> checkedOutItems) {

    long appleCount = checkedOutItems.stream().filter(item -> item.equals("apple")).count();
    long orangeCount = checkedOutItems.stream().filter(item -> item.equals("orange")).count();

    long chargeableApples = (appleCount / 2) + (appleCount % 2);
    long chargeableOranges = (orangeCount / 3) * 2 + (orangeCount % 3);

    var appleTotal = Items.APPLE.getPrice().multiply(BigDecimal.valueOf(chargeableApples));
    var orangeTotal = Items.ORANGE.getPrice().multiply(BigDecimal.valueOf(chargeableOranges));
    return appleTotal.add(orangeTotal);
  }
}
