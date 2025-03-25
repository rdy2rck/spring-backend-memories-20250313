package com.sjh.memories_backend.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sjh.memories_backend.common.dto.request.test.PostConcentrationRequestDto;
import com.sjh.memories_backend.common.dto.request.test.PostMemoryRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.dto.response.test.GetMemoryResponseDto;
import com.sjh.memories_backend.common.dto.response.test.GetRecentlyConcentrationResponseDto;
import com.sjh.memories_backend.common.dto.response.test.GetRecentlyMemoryResponseDto;
import com.sjh.memories_backend.common.entity.ConcentrationTestEntity;
import com.sjh.memories_backend.common.entity.MemoryTestEntity;
import com.sjh.memories_backend.repository.MemoryTestRepository;
import com.sjh.memories_backend.repository.ConcentrationTestRepository;
import com.sjh.memories_backend.common.dto.response.test.GetConcentrationResponseDto;
import com.sjh.memories_backend.service.TestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImplement implements TestService {

  private final MemoryTestRepository memoryTestRepository;
  private final ConcentrationTestRepository concentrationTestRepository;

  @Override
  public ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId) {

    try {
      MemoryTestEntity memoryTestEntity = null;

      Integer preSequence = memoryTestRepository.countByUserId(userId);
      if (preSequence == 0) {
        memoryTestEntity = new MemoryTestEntity(dto, userId);
      } else {
        MemoryTestEntity preMemoryTestEntity = memoryTestRepository.findByUserIdAndSequence(userId, preSequence);
        memoryTestEntity = new MemoryTestEntity(dto, preMemoryTestEntity, userId);
      }
      
      memoryTestRepository.save(memoryTestEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }

  @Override
  public ResponseEntity<ResponseDto> postConcentration(PostConcentrationRequestDto dto, String userId) {

    try {
      ConcentrationTestEntity concentrationTestEntity = null;

      Integer preSequence = concentrationTestRepository.countByUserId(userId);
      if (preSequence == 0) {
        concentrationTestEntity = new ConcentrationTestEntity(dto, userId);
      } else {
        ConcentrationTestEntity preConcentrationTestEntity = concentrationTestRepository.findByUserIdAndSequence(userId, preSequence);
        concentrationTestEntity = new ConcentrationTestEntity(dto, preConcentrationTestEntity, userId);
      }

      concentrationTestRepository.save(concentrationTestEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }

  @Override
  public ResponseEntity<? super GetMemoryResponseDto> getMemory(String userId) {

    List<MemoryTestEntity> memoryTestEntities = new ArrayList<>();

    try {
      
      memoryTestEntities = memoryTestRepository.findByUserIdOrderBySequenceDesc(userId);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetMemoryResponseDto.success(memoryTestEntities);
  }

  @Override
  public ResponseEntity<? super GetConcentrationResponseDto> getConcentration(String userId) {

    List<ConcentrationTestEntity> concentrationTestEntities = new ArrayList<>();

    try {
      
      concentrationTestEntities = concentrationTestRepository.findByUserIdOrderBySequenceDesc(userId); 

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetConcentrationResponseDto.success(concentrationTestEntities);
  }

  @Override
  public ResponseEntity<? super GetRecentlyMemoryResponseDto> getRecentlyMemory(String userId) {

    List<MemoryTestEntity> memoryTestEntities = new ArrayList<>();

    try {

      memoryTestEntities = memoryTestRepository.findTop10ByUserIdOrderBySequenceDesc(userId);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetRecentlyMemoryResponseDto.success(memoryTestEntities);
  }

  @Override
  public ResponseEntity<? super GetRecentlyConcentrationResponseDto> getRecentlyConcentration(String userId) {

    List<ConcentrationTestEntity> concentrationTestEntities = new ArrayList<>();

    try {

      concentrationTestEntities = concentrationTestRepository.findTop10ByUserIdOrderBySequenceDesc(userId);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetRecentlyConcentrationResponseDto.success(concentrationTestEntities);
  }
  
}
