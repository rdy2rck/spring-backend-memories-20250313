package com.sjh.memories_backend.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sjh.memories_backend.common.dto.request.diary.PostDiaryRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.entity.DiaryEntity;
import com.sjh.memories_backend.repository.DiaryRepository;
import com.sjh.memories_backend.service.DiaryService;
import com.sjh.memories_backend.common.dto.response.diary.GetDiaryResponseDto;
import com.sjh.memories_backend.common.dto.response.diary.GetMyDiaryResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImplement implements DiaryService {

  private final DiaryRepository diaryRepository;

  @Override
  public ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId) {

    try {

      DiaryEntity diaryEntity = new DiaryEntity(dto, userId);
      diaryRepository.save(diaryEntity);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }

  @Override
  public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId) {

    List<DiaryEntity> diaryEntities = new ArrayList<>();

    try {
      
      diaryEntities = diaryRepository.findByUserId(userId);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetMyDiaryResponseDto.success(diaryEntities);

  }

  @Override
  public ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber) {

    DiaryEntity diaryEntity = null;

    try {

      diaryEntity = diaryRepository.findByDiaryNumber(diaryNumber);
      if (diaryEntity == null) return ResponseDto.noExistDiary();

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetDiaryResponseDto.success(diaryEntity);

  }
  
}
