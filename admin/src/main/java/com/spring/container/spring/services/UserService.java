package com.spring.container.spring.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.container.spring.dtos.UsersDto;
import com.spring.container.spring.entities.booster.UserEntity;
import com.spring.container.spring.repositories.booster.UserRepository;
import com.spring.container.spring.specifications.UserSpecification;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserSpecification userSpecification;

  public Map<String , Object> users(UsersDto dto) {
    Page<UserEntity> users = this.userRepository.findAll(
      userSpecification.users(dto),
      PageRequest.of(dto.getPage(), dto.getCount())
    );
    long count = this.userRepository.count(userSpecification.users(dto));
    Map<String , Object> result = new HashMap<String , Object>();
    result.put("users", users.getContent());
    result.put("count" , count);
    return result;
  }
}
