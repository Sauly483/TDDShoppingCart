package com.saul.dev.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
