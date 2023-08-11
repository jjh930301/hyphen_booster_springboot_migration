package com.spring.container.spring.responses;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AdminModel {
  private Long id;
  private String user_num;
  private String name;
  private String user_id;
  private String email;
  private int type;
  private int status;
  private LocalDateTime created_at;
  private LocalDateTime login_at;
}

