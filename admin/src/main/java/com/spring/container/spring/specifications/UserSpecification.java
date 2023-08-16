package com.spring.container.spring.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.spring.container.spring.dtos.UsersDto;
import com.spring.container.spring.entities.booster.UserBusinessEntity;
import com.spring.container.spring.entities.booster.UserEntity;

@Component
public class UserSpecification {
  public Specification<UserEntity> users(UsersDto dto) {
    return (root , query , builder) -> {
      List<Predicate> condition = new ArrayList<Predicate>();
      Join<UserEntity , UserBusinessEntity> business = root.join("businesses" , JoinType.LEFT);
      if(dto.getStart_date() != null && dto.getEnd_date() != null) {
        condition.add(builder.between(root.get("createdAt"), dto.getStart_date(), dto.getEnd_date()));
      }
      
      if(dto.getType() != 0 && dto.getType() <= 3) {
        condition.add(builder.equal(root.get("type"), dto.getType()));
      }
      
      if(dto.getGender() != 0 && dto.getGender() <= 1) {
        condition.add(builder.equal(root.get("gender"), dto.getGender()));
      }
      
      if(dto.getSearch() != 0 && dto.getWord() != null) {
        condition.add(
          dto.getSearch() == 1 ? builder.like(root.get("userNum") , "%" + dto.getWord() + "%") : 
          dto.getSearch() == 2 ? builder.like(root.get("name") , "%" + dto.getWord() + "%") : 
          dto.getSearch() == 3 ? builder.like(root.get("mobile") , "%" + dto.getWord() + "%") : 
          dto.getSearch() == 4 ? builder.like(business.get("businessNumber") , "%" + dto.getWord() + "%") : null 
        );
      }
      
      if(dto.getBusiness() != 0 && dto.getBusiness() <= 2) {
        Predicate checkBusiness = dto.getBusiness() == 1 ? 
          builder.isNotNull(business.get("id")) :
          builder.isNull(business.get("id"));
        condition.add(checkBusiness);
      }
      
      if(dto.getConnected() != 0 && dto.getConnected() <= 2) {
        Predicate checkConnect = dto.getConnected() == 1 ? builder.or(
          builder.isNotNull(business.get("hometaxId")),
          builder.isNotNull(business.get("crefiaId")),
          builder.isNotNull(business.get("baeminId")),
          builder.isNotNull(business.get("yogiyoId")),
          builder.isNotNull(business.get("coupangeId")),
          builder.equal(business.get("isKsnet"), 1)
        ) : builder.and(
          builder.isNull(business.get("hometaxId")),
          builder.isNull(business.get("crefiaId")),
          builder.isNull(business.get("baeminId")),
          builder.isNull(business.get("yogiyoId")),
          builder.isNull(business.get("coupangeId")),
          builder.notEqual(business.get("isKsnet"), 1)
        );
        condition.add(checkConnect);
      }
      
      if(dto.getIs_paid() != 0 && dto.getIs_paid() <= 4) {
        condition.add(builder.equal(business.get("isPaid"), dto.getIs_paid()));
      }
      return condition.size() == 0 ? query.getRestriction() : builder.and(condition.toArray(new Predicate[condition.size()]));
    };
  }
}
