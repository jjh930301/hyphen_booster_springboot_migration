package com.spring.container.spring.constants;

public class Constant {
  public static final String COLLATE = " CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ";
  public static final String DB_URI = System.getenv("DB_URI");
  public static final String ADMIN_DB = System.getenv("ADMIN_DB");
  public static final String BOOSTER_DB = System.getenv("BOOSTER_DB");
  public static final String DB_USER = System.getenv("DB_USER");
  public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
}
