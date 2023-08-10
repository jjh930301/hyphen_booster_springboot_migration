package com.spring.container.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.spring.container.spring.entities.AdminUserEntity;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUserEntity , Long> , JpaSpecificationExecutor<AdminUserEntity>{
  AdminUserEntity findByUserId(String userId);
}
