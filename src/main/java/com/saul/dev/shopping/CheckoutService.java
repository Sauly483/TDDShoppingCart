package com.saul.dev.shopping;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutService {

  public List<String> checkout(List<String> items) {

    return items.stream().filter(item->item.equals("apple") || item.equals("orange")).toList();

  }
}
