package com.spring.container.spring.configs;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.container.spring.constants.Constant;

@Configuration
@EnableJpaRepositories(
  basePackages = "com.spring.container.spring.repositories.booster",
  entityManagerFactoryRef = "boosterEntityManagerFactory", 
  transactionManagerRef = "boosterTransactionManager"
)
public class BoosterDatabaseConfig {

  @Primary
  @Bean(name = "booster")
  public DataSource boosterDataSource() {

    return DataSourceBuilder.create()
      .url("jdbc:mysql://"+Constant.DB_URI+":3306/"+Constant.BOOSTER_DB+"?characterEncoding=UTF-8")
      .username(Constant.DB_USER)
      .password(Constant.DB_PASSWORD)
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .build();
  }

  @Bean(name = "boosterEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean boosterEntityManagerFactory(
    JpaVendorAdapter jpaVendorAdapter
  ) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(boosterDataSource());
	
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
        
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",System.getenv("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",System.getenv("hibernate.dialect"));
    em.setPackagesToScan("com.spring.container.spring.entities.booster");
    em.setJpaVendorAdapter(jpaVendorAdapter);
    return em;
  }

  @Bean(name = "boosterTransactionManager")
  public PlatformTransactionManager adminTransactionManager(
    @Qualifier("boosterEntityManagerFactory") EntityManagerFactory entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}