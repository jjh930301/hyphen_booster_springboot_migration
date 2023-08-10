package com.spring.container.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.spring.container.spring.constants.Constant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "admin_users" , schema = "booster_admin")
public class AdminUserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
    name = "user_num",
    nullable = true,
    columnDefinition = "VARCHAR(6)" + Constant.COLLATE + "COMMENT '식별할 키'"
  )
  private String userNum;

  @Column(
    name = "name",
    nullable = false,
    columnDefinition = "VARCHAR(10)" + Constant.COLLATE + "COMMENT '관리자 이름'"
  )
  private String name;

  @Column(
    name = "password",
    nullable = false,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT 'login password'"
  )
  private String password;

  @Column(
    name = "count",
    columnDefinition = "tinyint NOT NULL DEFAULT '0' COMMENT '실패 횟수'"
  )
  private int count;

  @Column(
    name = "email",
    columnDefinition = "varchar(100)"+ Constant.COLLATE +"NOT NULL COMMENT 'email'"
  )
  private String email;

  @Column(
    name = "user_id",
    nullable = false,
    columnDefinition = "VARCHAR(15)" + Constant.COLLATE + "COMMENT 'login id'"
  )
  private String userId;

  @Column(
    name = "refresh_token",
    nullable = false,
    columnDefinition = "VARCHAR(355)" + Constant.COLLATE + "COMMENT '리프레시 토큰'"
  )
  private String refreshToken;

  @Column(
    name = "mobile",
    nullable = false,
    columnDefinition = "VARCHAR(15)" + Constant.COLLATE + "COMMENT '전화번호'"
  )
  private String mobile;

  @Column(
    name = "type",
    nullable = false,
    columnDefinition = "tinyint COMMENT '관리자 권한 0 : permission all , 1 : admin'"
  )
  private int type;

  @Column(
    name = "status",
    nullable = false,
    columnDefinition = "tinyint COMMENT '0 : 사용 , 1 : 중지 , 2 : 해지'"
  )
  private int status;

  @Column(
    name = "login_at",
    nullable = false,
    columnDefinition = "datetime COMMENT '최근 로그인'"
  )
  private String loginAt;

  @Column(
    name = "stoped_at",
    nullable = false,
    columnDefinition = "datetime COMMENT '중지일'"
  )
  private String stopedAt;

  @Column(
    name = "terminated_at",
    nullable = false,
    columnDefinition = "datetime COMMENT '중지일'"
  )
  private String terminatedAt;

  @CreatedDate
  private String createdAt;
}
