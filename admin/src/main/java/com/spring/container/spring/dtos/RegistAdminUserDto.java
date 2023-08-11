package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistAdminUserDto {
  @Schema(
    required = true
  )
  private String user_id;

  @Schema(
    required = true
  )
  private String password;

  @Schema(
    required = true
  )
  private String name;

  @Schema(
    required = true
  )
  private String mobile;

  @Schema(
    required = true
  )
  private String email;

  @Schema(
    required = true
  )
  private int type;
}
