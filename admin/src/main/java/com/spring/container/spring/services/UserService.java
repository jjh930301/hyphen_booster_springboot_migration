package com.spring.container.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.container.spring.dtos.UsersDto;
import com.spring.container.spring.entities.UserEntity;
import com.spring.container.spring.repositories.UserRepository;
import com.spring.container.spring.specifications.UserSpecification;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserSpecification userSpecification;

  public Page<UserEntity> users(UsersDto dto) {
    Page<UserEntity> users = this.userRepository.findAll(
      userSpecification.users(),
      PageRequest.of(dto.getPage(), dto.getCount())
    );
    return users;
  }
}
