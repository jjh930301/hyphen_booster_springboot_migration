package com.spring.container.spring.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.container.spring.dtos.RegistAdminUserDto;
import com.spring.container.spring.services.AuthService;
import com.spring.container.spring.utils.ApiRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(
  path = "/auth",
  produces = MediaType.APPLICATION_JSON_VALUE
)
public class AuthController {

  @Autowired
  private AuthService authService;

  @Operation(
    summary = "관리자 유저 등록"
  )
  @PostMapping(
    path = "/user"
  )
  public ResponseEntity<?> registAdminUser(
    @RequestHeader HttpHeaders authorizationHeader,
    @RequestBody RegistAdminUserDto dto,
    @Parameter(hidden = true) HttpServletRequest request
  ) {
    int type = (int) request.getAttribute("token_type");
    ApiRes response = new ApiRes();
    if (type != 0 ) {
      response.setMessages(Arrays.asList("Forbidden"));
      response.setPayload(null);
      response.setResult_code(4003);
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
    boolean result = this.authService.registAdminuser(dto);
    response.setMessages(Arrays.asList("Successfully create admin user"));
    response.setResult_code(2001);
    response.setPayload(result);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
