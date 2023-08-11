package com.spring.container.spring.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import com.spring.container.spring.constants.Constant;

import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users" , schema = "booster")
public class UserEntity{
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(
    name = "uuid2", 
    strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(
    name = "id", 
    updatable = false, 
    nullable = false, 
    columnDefinition = "VARCHAR(36)"
  )
  @Type(type = "uuid-char")
  private UUID id;

  @OneToMany(
    mappedBy = "user",
    targetEntity = UserBusinessEntity.class
  )
  private List<UserBusinessEntity> businesses;

  @Column(
    name = "client_id",
    nullable = false,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT 'ci'"
  )
  private String clientId;

  @Column(
    name = "di",
    nullable = false,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT 'di'"
  )
  private String di;

  @Column(
    name = "user_num",
    nullable = true,
    columnDefinition = "VARCHAR(15)" + Constant.COLLATE + "COMMENT 'user number'"
  )
  private String userNum;

  @Column(
    name = "mobile",
    nullable = false,
    columnDefinition = "VARCHAR(30)" + Constant.COLLATE + "COMMENT 'mobile number'"
  )
  private String mobile;

  @Column(
    name = "mobile_company",
    nullable = true,
    columnDefinition = "VARCHAR(1)" + Constant.COLLATE + "COMMENT '통신사'"
  )
  private String mobileCompany;

  @Column(
    name = "date_of_birth",
    nullable = false,
    columnDefinition = "date COMMENT '생년월일'"
  )
  private LocalDate dateOfBirth;

  @Column(
    name = "type",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '0 : 사용 1 : 휴면 2 : 정지 3 : 탈퇴'"
  )
  private int type;

  @Column(
    name = "kakao_alert",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '0 : 수신 1 : 비수신'"
  )
  private boolean kakaoAlert;

  @Column(
    name = "created_at",
    nullable = true,
    columnDefinition = "datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '생성일'"
  )
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(
    name = "updated_at",
    nullable = true,
    columnDefinition = "datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '최근 업데이트일'"
  )
  @CreatedDate
  private LocalDateTime updatedAt;

  @Column(
    name = "refreshed_at",
    nullable = true,
    columnDefinition = "date NOT NULL DEFAULT (curdate()) COMMENT '최근 접속일'"
  )
  private LocalDateTime refreshedAt;

  @Column(
    name = "deleted_at",
    nullable = true
  )
  private LocalDateTime deletedAt;
}
