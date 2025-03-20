package com.sjh.memories_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_backend.common.entity.DiaryEntity;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {

  DiaryEntity findByDiaryNumber(Integer diaryNumber);
  
  List<DiaryEntity> findByUserIdOrderByWriteDateDesc(String userId);
  
}
