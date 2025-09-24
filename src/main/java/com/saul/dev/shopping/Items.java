package com.saul.dev.shopping;

import java.math.BigDecimal;

public enum Items {

  APPLE(new BigDecimal("0.60")),
  ORANGE(new BigDecimal("0.25"));

  private final BigDecimal price;

  Items(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
