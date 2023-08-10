package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "로그인")
public class LoginDto {
  @Schema(defaultValue = "id",description = "user_id")
  private String id;
  
  @Schema(defaultValue = "password",description = "password")
  private String password;
}
