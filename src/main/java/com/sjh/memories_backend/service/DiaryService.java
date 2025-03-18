package com.sjh.memories_backend.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_backend.common.dto.request.diary.PostDiaryRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.dto.response.diary.GetMyDiaryResponseDto;
import com.sjh.memories_backend.common.dto.response.diary.GetDiaryResponseDto;

public interface DiaryService {
  ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId);
  ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId);
  ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber);
}
