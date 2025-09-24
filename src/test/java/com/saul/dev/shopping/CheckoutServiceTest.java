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

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    assertEquals(2, checkedOutItems.size());
  }

  @Test
  void testTotalShouldBeValidForEachItem() {
    List<String> items = List.of("apple", "orange");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    BigDecimal total = checkoutService.total(checkedOutItems);
    assertEquals(new BigDecimal("0.85"), total);
  }


  @Test
  void testTotalShouldBeValidForMultipleItems() {
    List<String> items = List.of("apple", "apple", "apple", "orange");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    BigDecimal total = checkoutService.total(checkedOutItems);
    assertEquals(new BigDecimal("1.45"), total);
  }

  @Test
  void testTotalShouldBeZeroWhenNoValidItems() {
    List<String> items = List.of("banana", "grape");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    BigDecimal total = checkoutService.total(checkedOutItems);
    assertEquals(new BigDecimal("0.00"), total);
  }

  @Test
  void testTotalShouldBeForOneAppleWithOffer() {
    List<String> items = List.of("apple","apple");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    BigDecimal total = checkoutService.total(checkedOutItems);

    assertEquals(new BigDecimal("0.60"), total);
  }

  @Test
  void testTotalShouldBeForOneOrangeWithOffer() {
    List<String> items = List.of("orange","orange","orange");
    CheckoutService checkoutService = new CheckoutService();

    List<String> checkedOutItems = checkoutService.filterBasket(items);
    BigDecimal total = checkoutService.total(checkedOutItems);

    assertEquals(new BigDecimal("0.50"), total);
  }



}
