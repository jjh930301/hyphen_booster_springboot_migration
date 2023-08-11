package com.spring.container.spring.enums;

public enum TokenEnum {
  ACCESS_TOKEN(0),
  REFRESH_TOKEN(1);

  private int value;

  private TokenEnum(int i) {
    value = i;
  }
  public int getValue() {
    return this.value;
  }
}

