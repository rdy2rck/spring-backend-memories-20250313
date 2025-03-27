package com.sjh.memories_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_backend.common.entity.CommentEntity;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

  List<CommentEntity> findByDiaryNumberOrderByWriteDateDesc(Integer diaryNumber);

  @Transactional
  void deleteByDiaryNumber(Integer diaryNumber);
  
}
