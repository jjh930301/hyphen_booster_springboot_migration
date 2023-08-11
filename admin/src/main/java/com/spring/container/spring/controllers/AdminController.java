package com.spring.container.spring.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.container.spring.dtos.LoginDto;
import com.spring.container.spring.entities.AdminUserEntity;
import com.spring.container.spring.enums.TokenEnum;
import com.spring.container.spring.responses.AdminModel;
import com.spring.container.spring.responses.LoginResponse;
import com.spring.container.spring.services.AdminService;
import com.spring.container.spring.utils.ApiRes;
import com.spring.container.spring.utils.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "admin")
@RestController
@RequestMapping(
  path = "",
  produces = MediaType.APPLICATION_JSON_VALUE
)
public class AdminController {

  @Autowired
  private AdminService adminService;

  @Autowired
  private JwtUtil jwtUtil;

  @Operation(
    summary = "로그인",
    description = ""
  )
  @ApiResponse(
    responseCode = "200",
    content = @Content(
      mediaType = "application/json",
      schema = @Schema(
        implementation = LoginResponse.class
      )
    )
  )
  @PostMapping(
    path = "/login"
  )
  public ResponseEntity<?> login(
    @RequestBody LoginDto dto
  ) {
    AdminUserEntity model = this.adminService.login(dto);
    if(model == null) {
      return ResponseEntity.badRequest().body(new ApiRes(4000, Arrays.asList("bad request"), null));
    }
    String accessToken = this.jwtUtil.createToken(model.getUserId(), model.getEmail(), model.getType(), TokenEnum.ACCESS_TOKEN.ordinal());
    LoginResponse responseModel = LoginResponse.builder()
      .admin(
        AdminModel.builder()
          .id(model.getId())
          .user_id(model.getUserId())
          .user_num(model.getUserNum())
          .name(model.getName())
          .email(model.getEmail())
          .type(model.getType())
          .status(model.getStatus())
          .created_at(model.getCreatedAt())
          .login_at(model.getLoginAt())
          .build()
      )
      .access_token(accessToken)
      .refresh_token(model.getRefreshToken())
      .build();
    ApiRes response = new ApiRes(2000 , Arrays.asList("Succssfully login") , responseModel);
    return ResponseEntity.ok(response);
  }
}
