package com.sjh.memories_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_backend.common.entity.UserEntity;
import java.util.List;



@Repository
// JpaRespository<목표Entity, 목표Entity기본타입>
public interface UserRepository extends JpaRepository<UserEntity, String> {

  boolean existsByUserId(String userId);

  UserEntity findByUserId(String userId);
  UserEntity findByJoinTypeAndSnsId(String joinType, String snsId);
  
}
