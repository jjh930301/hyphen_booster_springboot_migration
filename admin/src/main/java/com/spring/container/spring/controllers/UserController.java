package com.spring.container.spring.controllers;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.container.spring.dtos.UsersDto;
import com.spring.container.spring.entities.UserEntity;
import com.spring.container.spring.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "user")
@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Operation(
    summary = "유저 목록"
  )
  @GetMapping(
    path = ""
  )
  public ResponseEntity<?> users(
    @ParameterObject UsersDto dto
  ) {
    Page<UserEntity> users = this.userService.users(dto);
    return ResponseEntity.ok(users.getContent());
  }
}
