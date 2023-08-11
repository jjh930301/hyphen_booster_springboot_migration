package com.spring.container.spring.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.container.spring.dtos.RegistAdminUserDto;
import com.spring.container.spring.entities.AdminUserEntity;
import com.spring.container.spring.enums.TokenEnum;
import com.spring.container.spring.repositories.AdminUserRepository;
import com.spring.container.spring.utils.JwtUtil;

@Service
public class AuthService {
  @Autowired
  private AdminUserRepository adminUserRepository;
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public boolean registAdminuser(RegistAdminUserDto dto) {
    String refreshToken = this.jwtUtil.createToken(
      dto.getUser_id(), 
      dto.getEmail(), 
      dto.getType() , 
      TokenEnum.REFRESH_TOKEN.ordinal()
    );
    AdminUserEntity adminUser = AdminUserEntity.builder()
      .userId(dto.getUser_id())
      .password(passwordEncoder.encode(dto.getPassword()))
      .email(dto.getEmail())
      .name(dto.getName())
      .mobile(dto.getMobile())
      .type(dto.getType())
      .refreshToken(refreshToken)
      .createdAt(LocalDateTime.now())
      .build();
    this.adminUserRepository.save(adminUser);
    adminUser.setUserNum("MA-"+adminUser.getId());
    this.adminUserRepository.save(adminUser);
    return true;
  }
}
