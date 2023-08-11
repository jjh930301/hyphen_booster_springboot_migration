package com.spring.container.spring.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponse {
  private AdminModel admin;
  private String access_token;
  private String refresh_token;
}

