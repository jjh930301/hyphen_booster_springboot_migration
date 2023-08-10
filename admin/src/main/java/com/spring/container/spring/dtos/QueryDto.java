package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "QueryDto")
public class QueryDto {
  @Schema(defaultValue = "1")
  private int page;

  @Schema(defaultValue = "10")
  private int count;
}
