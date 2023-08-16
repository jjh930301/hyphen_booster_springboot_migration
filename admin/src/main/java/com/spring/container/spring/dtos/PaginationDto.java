package com.spring.container.spring.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
  @Schema(
    required = true,
    requiredMode = RequiredMode.REQUIRED
  )
  private int page;
  @Schema(
    required = true,
    requiredMode = RequiredMode.REQUIRED
  )
  private int count;

  @Schema(
    required = false,
    example = "2023-01-18T00:00:00",
    requiredMode = RequiredMode.NOT_REQUIRED
)
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime start_date;
  
  @Schema(
    required = false,
    example = "2023-02-18T00:00:00",
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime end_date;
}
