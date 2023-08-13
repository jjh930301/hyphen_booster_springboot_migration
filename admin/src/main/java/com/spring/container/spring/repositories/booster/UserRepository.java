package com.spring.container.spring.repositories.booster;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.spring.container.spring.entities.booster.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , UUID> , JpaSpecificationExecutor<UserEntity>{
  
}
