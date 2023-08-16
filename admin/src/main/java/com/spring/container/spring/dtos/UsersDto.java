package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto extends PaginationDto {
  
  @Schema(
    description = "1 : 사용 <br>" +
    "2 : 휴면 <br>" +
    "3 : 중지 <br>" +
    "4 : 탈퇴 ",
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int type;
  @Schema(
    description = "1 : 남자 <br>" +
    "2 : 여자",
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int gender;
  @Schema(
    description = "1 : 사업자가 등록된 유저 <br>" +
    "2 : 사업자가 등록되지 않은 유저",
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int business;
  @Schema(
    description = "1 : 연결기관 연결된 유저 <br>" +
    "2 : 연결기관이 연결되지 않은 유저",
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int connected;
  @Schema(
    description = "1 : 아무것도 신청하지 않은 유저 <br>" + 
    "2 : 선정산 유저 <br>" +
    "3 : 선정산 신청중인 유저 <br>" +
    "4 : 선정산 반려된 유저 <br>" +
    "5 : 선정산 해지된 유저",
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int is_paid;
  @Schema(
    description = "검색할 단어"
  )
  private String word;
  @Schema(
    description = "1 : 회원번호 <br>" +
    "2 : 이름 <br>" +
    "3 : 휴대폰 번호 <br>" +
    "4 : 사업자 번호" ,
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private int search;

}
