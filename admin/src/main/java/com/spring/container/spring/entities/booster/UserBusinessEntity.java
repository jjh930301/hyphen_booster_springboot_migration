package com.spring.container.spring.entities.booster;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import com.spring.container.spring.constants.Constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_businesses" , schema = "booster")
public class UserBusinessEntity {
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

  @ManyToOne(
    targetEntity = UserEntity.class
  )
  @OnDelete(action = OnDeleteAction.CASCADE)
  private UserEntity user;

  @Column(
    name = "business_number",
    nullable = false,
    columnDefinition = "VARCHAR(40)" + Constant.COLLATE + "COMMENT '사업자 번호'"
  )
  private String businessNumber;
  
  @Column(
    name = "member_group_id",
    nullable = false,
    columnDefinition = "VARCHAR(20)" + Constant.COLLATE + "COMMENT '여신에서 주는 group id'"
  )
  private String memberGroupId;

  @Column(
    name = "store_name",
    nullable = false,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT '상호명'"
  )
  private String storeName;

  @Column(
    name = "address",
    nullable = true,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT '주소'"
  )
  private String address;

  @Column(
    name = "sector",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '업종'"
  )
  private String sector;
  
  @Column(
    name = "type",
    nullable = true,
    columnDefinition = "tinyint NOT NULL DEFAULT '0' COMMENT '0 : default , 1 : ksnet'"
  )
  private int type;

  @Column(
    name = "tax_type",
    nullable = true,
    columnDefinition = "tinyint NOT NULL COMMENT '사업자 유형'"
  )
  private int taxType;

  @Column(
    name = "is_ksnet",
    nullable = true,
    columnDefinition = "tinyint NOT NULL DEFAULT '0' COMMENT '0 : 일반 유저 / 1 : ksnet 유저 / 2 : ksnet 유저이지만 동의하지 않음 | ksnet 동의 내용을 보여주지 않음'"
  )
  private int isKsnet;

  @Column(
    name = "is_paid",
    nullable = true,
    columnDefinition = "tinyint NOT NULL DEFAULT '0' COMMENT '0 : default / 1 : 선정산 / 2 : 신청중 / 3 : 반려 / 4 : 해지'"
  )
  private int isPaid;

  @Column(
    name = "h_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "선정산에 사용되는 id"
  )
  private String hId;

  @Column(
    name = "status",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '업태'"
  )
  private String status;

  @Column(
    name = "crefia_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '여신 ID'"
  )
  private String crefiaId;

  @Column(
    name = "crefia_password",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '여신 비밀번호'"
  )
  private String crefiaPassword;

  @Column(
    name = "crefia_updated_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '여신 계정 등록일'"
  )
  private LocalDateTime crefiaUpdatedAt;

  @Column(
    name = "crefia_recented_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '여신 최근 업데이트일시'"
  )
  private LocalDateTime crefiarecentedAt;

  @Column(
    name = "crefia_login",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '여신금융 로그인 상태'"
  )
  private boolean crefiaLogin;

  @Column(
    name = "hometax_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '홈택스 ID'"
  )
  private String hometaxId;

  @Column(
    name = "hometax_password",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '홈택스 비밀번호'"
  )
  private String hometaxPassword;

  @Column(
    name = "hometax_updated_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '홈택스 계정 등록일'"
  )
  private LocalDateTime hometaxUpdatedAt;

  @Column(
    name = "hometax_recented_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '홈택스 최근 업데이트일시'"
  )
  private LocalDateTime hometaxrecentedAt;

  @Column(
    name = "hometax_login",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '홈택스 로그인 상태'"
  )
  private boolean hometaxLogin;

  @Column(
    name = "baemin_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '배민 ID'"
  )
  private String baeminId;

  @Column(
    name = "baemin_password",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '배민 비밀번호'"
  )
  private String baeminPassword;

  @Column(
    name = "baemin_updated_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '배민 계정 등록일'"
  )
  private LocalDateTime baeminUpdatedAt;

  @Column(
    name = "baemin_recented_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '배민 최근 업데이트일시'"
  )
  private LocalDateTime baeminrecentedAt;

  @Column(
    name = "baemin_login",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '배민 로그인 상태'"
  )
  private boolean baeminLogin;

  @Column(
    name = "baemin_store_id",
    nullable = true,
    columnDefinition = "varchar(100)" + Constant.COLLATE + "DEFAULT NULL COMMENT '배민 storeid lenght가 변경될 수 있습니다'"
  )
  private String baeminStoreId;

  @Column(
    name = "yogiyo_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '요기요 ID'"
  )
  private String yogiyoId;

  @Column(
    name = "yogiyo_password",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '요기요 비밀번호'"
  )
  private String yogiyoPassword;

  @Column(
    name = "yogiyo_updated_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '요기요 계정 등록일'"
  )
  private LocalDateTime yogiyoUpdatedAt;

  @Column(
    name = "yogiyo_recented_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '요기요 최근 업데이트일시'"
  )
  private LocalDateTime yogiyorecentedAt;

  @Column(
    name = "yogiyo_login",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '요기요 로그인 상태'"
  )
  private boolean yogiyoLogin;

  @Column(
    name = "yogiyo_store_id",
    nullable = true,
    columnDefinition = "varchar(100)" + Constant.COLLATE + "DEFAULT NULL COMMENT '요기요 storeid'"
  )
  private String yogiyoStoreId;

  @Column(
    name = "coupange_id",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '요기요 ID'"
  )
  private String coupangeId;

  @Column(
    name = "coupange_password",
    nullable = true,
    columnDefinition = "VARCHAR(100)" + Constant.COLLATE + "COMMENT '요기요 비밀번호'"
  )
  private String coupangePassword;

  @Column(
    name = "coupange_updated_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '요기요 계정 등록일'"
  )
  private LocalDateTime coupangeUpdatedAt;

  @Column(
    name = "coupange_recented_at",
    nullable = true,
    columnDefinition = "datetime default null COMMENT '요기요 최근 업데이트일시'"
  )
  private LocalDateTime coupangerecentedAt;

  @Column(
    name = "coupange_login",
    nullable = true,
    columnDefinition = "tinyint default 0 COMMENT '요기요 로그인 상태'"
  )
  private boolean coupangeLogin;

  @Column(
    name = "coupange_store_id",
    nullable = true,
    columnDefinition = "varchar(100)" + Constant.COLLATE + "DEFAULT NULL COMMENT '요기요 storeid'"
  )
  private String coupangeStoreId;

  @Column(
    name = "cert",
    nullable = true,
    columnDefinition = "text" + Constant.COLLATE
  )
  private String cert;

  @Column(
    name = "pri",
    nullable = true,
    columnDefinition = "text" + Constant.COLLATE
  )
  private String pri;

  @Column(
    name = "cert_password",
    nullable = true,
    columnDefinition = "text" + Constant.COLLATE
  )
  private String certPassword;

  @Column(
    name = "cert_number",
    nullable = true,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT '인증서 번호'"
  )
  private String certNumber;

  @Column(
    name = "cert_issuer",
    nullable = true,
    columnDefinition = "VARCHAR(255)" + Constant.COLLATE + "COMMENT '인증서 발급자'"
  )
  private String certIssuer;

  @Column(
    name = "opened_at",
    nullable = true,
    columnDefinition = "date DEFAULT NULL COMMENT '개업일자'"
  )
  private LocalDate openedAt;

  @Column(
    name = "cert_expiration",
    nullable = true,
    columnDefinition = "date DEFAULT null COMMENT '인증서 만료일'"
  )
  private LocalDateTime certExpiration;

  @Column(
    name = "cert_updated_at",
    nullable = true,
    columnDefinition = "datetime DEFAULT NUL COMMENT '인증서 등록일'"
  )
  private LocalDateTime certUpdatedAt;

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
  private LocalDateTime updatedAt;

  @Column(
    name = "deleted_at",
    nullable = true
  )
  private LocalDateTime deletedAt;
}
