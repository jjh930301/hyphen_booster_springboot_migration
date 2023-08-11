package com.spring.container.spring.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.spring.container.spring.entities.UserEntity;

@Component
public class UserSpecification {
  public Specification<UserEntity> users() {
    return (root , query , builder) -> {
      return query.getRestriction();
    };
  }
}
