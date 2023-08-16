package com.spring.container.spring.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.container.spring.dtos.LoginDto;
import com.spring.container.spring.entities.admin.AdminUserEntity;
import com.spring.container.spring.repositories.admin.AdminUserRepository;

@Service
public class AdminService {

  @Autowired
  private AdminUserRepository adminUserRepository;
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  public AdminUserEntity login(LoginDto dto) {
    AdminUserEntity adminUser = this.adminUserRepository.findByUserId(dto.getId());
    if(adminUser == null) {
      return null;
    }
    boolean checkPassword = passwordEncoder.matches(dto.getPassword(),adminUser.getPassword());
    if(!checkPassword) {
      return null;
    }
    adminUser.setLoginAt(LocalDateTime.now());
    this.adminUserRepository.save(adminUser);
    return adminUser;
  }
}
