package com.spring.container.spring.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.container.spring.interceptors.JwtInterceptor;

@Configuration
public class InterceporConfig implements WebMvcConfigurer{
  
  @Autowired
  private JwtInterceptor jwtInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtInterceptor)
      .addPathPatterns("/auth/**");
  }
}
