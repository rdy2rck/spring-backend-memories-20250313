package com.sjh.memories_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_backend.common.entity.EmpathyEntity;
import com.sjh.memories_backend.common.entity.pk.EmpathyPk;

import jakarta.transaction.Transactional;

@Repository
public interface EmpathyRepository extends JpaRepository<EmpathyEntity, EmpathyPk> {

  EmpathyEntity findByUserIdAndDiaryNumber(String userId, Integer diaryNumber);
  List<EmpathyEntity> findByDiaryNumber(Integer diaryNumber);

  @Transactional
  void deleteByDiaryNumber(Integer diaryNumber);

} 
