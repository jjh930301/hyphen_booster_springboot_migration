package com.spring.container.spring.controllers;

import java.util.Arrays;
import java.util.Map;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.container.spring.dtos.UsersDto;
import com.spring.container.spring.services.UserService;
import com.spring.container.spring.utils.ApiRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@Tag(name = "user")
@RestController
@RequestMapping(
  path = "/user",
  produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {
  @Autowired
  private UserService userService;
  @Operation(
    summary = "유저 목록"
  )
  @GetMapping(
    path = ""
  )
  public Mono<?> users(
    @ParameterObject UsersDto dto,
    @RequestHeader HttpHeaders headers
  ) {
    Map<String , Object> result = this.userService.users(dto);
    return Mono.just(new ApiRes(2000 , Arrays.asList("Successfully getting users") , result ));
  }
}
