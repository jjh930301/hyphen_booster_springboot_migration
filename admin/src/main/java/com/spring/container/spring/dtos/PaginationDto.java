package com.spring.container.spring.dtos;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
  @Schema(
    name = "page",
    required = true
  )
  private int page;
  @Schema(
    name = "count",
    required = true
  )
  private int count;

  @Schema(
    required = false
  )
  private LocalDate start_date;
  
  @Schema(
    required = false
  )
  private LocalDate end_date;
}
