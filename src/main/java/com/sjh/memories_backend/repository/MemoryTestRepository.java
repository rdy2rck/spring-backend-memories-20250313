package com.sjh.memories_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_backend.common.entity.MemoryTestEntity;
import com.sjh.memories_backend.common.entity.pk.MemoryTestPk;
import java.util.List;


@Repository
// 목표Entity가 복합 타입일 경우
// 1. entity/pk 폴더에 PK 파일 형성
// 2. 목표Entity에 @IdClass(1번에서생성한PK.class) 입력
// 3. 목표Entity기본타입 자리에 생성한 PK파일명 입력 후 임포트
public interface MemoryTestRepository extends JpaRepository<MemoryTestEntity, MemoryTestPk>{

  int countByUserId(String userId);

  MemoryTestEntity findByUserIdAndSequence(String userId, Integer equence);
  List<MemoryTestEntity> findByUserIdOrderBySequenceDesc(String userId);
  List<MemoryTestEntity> findTop10ByUserIdOrderBySequenceDesc(String userId);
  
}
