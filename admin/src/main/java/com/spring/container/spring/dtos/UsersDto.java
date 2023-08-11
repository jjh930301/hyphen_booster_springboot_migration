package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto extends PaginationDto {
  @Schema(
    description = "0 : 사용 <br>" +
    "1 : 휴면 <br>" +
    "2 : 중지 <br>" +
    "3 : 탈퇴 ",
    required = false
  )
  private int type;
  @Schema(
    description = "0 : 남자 <br>" +
    "1 : 여자",
    required = false
  )
  private int gender;
  @Schema(
    description = "1 : 사업자가 등록된 유저 <br>" +
    "2 : 사업자가 등록되지 않은 유저",
    required = false
  )
  private int business;
  @Schema(
    description = "1 : 연결기관 연결된 유저 <br>" +
    "2 : 연결기관이 연결되지 않은 유저",
    required = false
  )
  private int connected;
  @Schema(
    description = "0 : 아무것도 신청하지 않은 유저 <br>" + 
    "1 : 선정산 유저 <br>" +
    "2 : 선정산 신청중인 유저 <br>" +
    "3 : 선정산 반려된 유저 <br>" +
    "4 : 선정산 해지된 유저",
    required = false
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
    "4 : 사업자 번호" 
  )
  private String search;

}
