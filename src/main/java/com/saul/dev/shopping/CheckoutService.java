package com.saul.dev.shopping;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

  public List<String> filterBasket(List<String> items) {

    return items.stream()
        .filter(item -> item.equals("apple") ||
            item.equals("orange") || item.equals("banana")).toList();

  }

  public BigDecimal total(List<String> checkedOutItems) {

    long appleCount = checkedOutItems.stream().filter(item -> item.equals("apple")).count();
    long orangeCount = checkedOutItems.stream().filter(item -> item.equals("orange")).count();
    long bananaCount = checkedOutItems.stream().filter(item -> item.equals("banana")).count();

    List<Long> chargeableItems = calculateOffers(appleCount, orangeCount, bananaCount);


    var appleTotal = Items.APPLE.getPrice().multiply(BigDecimal.valueOf(chargeableItems.get(0)));
    var orangeTotal = Items.ORANGE.getPrice().multiply(BigDecimal.valueOf(chargeableItems.get(1)));
    var bananaTotal = Items.BANANAS.getPrice().multiply(BigDecimal.valueOf(chargeableItems.get(2)));
    return appleTotal.add(orangeTotal).add(bananaTotal);
  }

  private List<Long> calculateOffers(final long appleCount, final long orangeCount, final long bananaCount) {

    if (appleCount > 0 && bananaCount > 0) {
      return List.of((appleCount / 2) + (appleCount % 2),
          (orangeCount / 3) * 2 + (orangeCount % 3), (bananaCount - 1));
    }
    return List.of((appleCount / 2) + (appleCount % 2),
        (orangeCount / 3) * 2 + (orangeCount % 3), (bananaCount /2) + (bananaCount %2));


  }

}
