package com.saul.dev.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CheckoutServiceTest {


  @Test
  void testShouldAllowOnlyApplesAndOranges() {
    List<String> items = List.of("apple", "orange", "banana");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.checkout(items);
    assertEquals(2, checkedOutItems.size());
  }

  @Test
  void testTotalShouldBeValidForEachItem() {
    List<String> items = List.of("apple", "orange");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.checkout(items);
    BigDecimal total = checkoutService.total(checkedOutItems);
    assertEquals(new BigDecimal("0.85"), total);
  }


  @Test
  void testTotalShouldBeValidForMultipleItems() {
    List<String> items = List.of("apple", "apple", "apple", "orange");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.checkout(items);
    BigDecimal total = checkoutService.total(checkedOutItems);
    assertEquals(new BigDecimal("2.05"), total);
  }



}
