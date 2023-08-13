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
  basePackages = "com.spring.container.spring.repositories.admin",
  entityManagerFactoryRef = "adminEntityManagerFactory",
  transactionManagerRef = "adminTransactionManager"
)
public class AdminDatabaseConfig {

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    return new HibernateJpaVendorAdapter();
  }

  @Primary
  @Bean(name = "admin")
  public DataSource adminDataSource() {
    return DataSourceBuilder.create()
      .url("jdbc:mysql://"+Constant.DB_URI+":3306/"+Constant.ADMIN_DB+"?characterEncoding=UTF-8")
      .username(Constant.DB_USER)
      .password(Constant.DB_PASSWORD)
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .build();
  }
  
  @Bean(name = "adminEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean adminEntityManagerFactory(
    JpaVendorAdapter jpaVendorAdapter
  ) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(adminDataSource());

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

    Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",System.getenv("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",System.getenv("hibernate.dialect"));
    em.setPackagesToScan("com.spring.container.spring.entities.admin");
    em.setJpaVendorAdapter(jpaVendorAdapter);
    return em;
  }

  @Primary
  @Bean(name = "adminTransactionManager")
  public PlatformTransactionManager boosterTransactionManager(
    @Qualifier("adminEntityManagerFactory") EntityManagerFactory entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
