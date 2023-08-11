package com.spring.container.spring.configs;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {
  private final String DB_URI = System.getenv("DB_URI");
  private final String ADMIN_DB = System.getenv("ADMIN_DB");
  private final String BOOSTER_DB = System.getenv("BOOSTER_DB");
  private final String DB_USER = System.getenv("DB_USER");
  private final String DB_PASSWORD = System.getenv("DB_PASSWORD");

  @Primary
  @Bean(name = "booster")
  public DataSource boosterDataSource() {
    return DataSourceBuilder.create()
      .url("jdbc:mysql://"+DB_URI+":3306/"+BOOSTER_DB+"?characterEncoding=UTF-8")
      .username(DB_USER)
      .password(DB_PASSWORD)
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .build();
  }

  @Bean(name = "admin")
  public DataSource adminDataSource() {
    return DataSourceBuilder.create()
      .url("jdbc:mysql://"+DB_URI+":3306/"+ADMIN_DB+"?characterEncoding=UTF-8")
      .username(DB_USER)
      .password(DB_PASSWORD)
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .build();
  }
}