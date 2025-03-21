package com.sjh.memories_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjh.memories_backend.common.dto.request.diary.PatchDiaryRequestDto;
import com.sjh.memories_backend.common.dto.request.diary.PostDiaryRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.dto.response.diary.GetMyDiaryResponseDto;
import com.sjh.memories_backend.service.DiaryService;
import com.sjh.memories_backend.common.dto.response.diary.GetDiaryResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {
  
  private final DiaryService diaryService;

  @PostMapping({"", "/"})
  public ResponseEntity<ResponseDto> postDiary(
    @RequestBody @Valid PostDiaryRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<ResponseDto> response = diaryService.postDiary(requestBody, userId);
    return response;
  }

  @GetMapping("/my")
  public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super GetMyDiaryResponseDto> response = diaryService.getMyDiary(userId);
    return response;
  }

  @GetMapping("/{diaryNumber}")
  public ResponseEntity<? super GetDiaryResponseDto> getDiary(
    @PathVariable("diaryNumber") Integer diaryNumber
  ) {
    ResponseEntity<? super GetDiaryResponseDto> response = diaryService.getDiary(diaryNumber);
    return response;
  }

  @PatchMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> patchDiary(
  @RequestBody @Valid PatchDiaryRequestDto requestBody, 
  @PathVariable("diaryNumber") Integer diaryNumber,
  @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<ResponseDto> response = diaryService.patchDiary(requestBody, diaryNumber, userId);
    return response;
  }

  @DeleteMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> deleteDiary(
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userid
  ) {
    ResponseEntity<ResponseDto> response = diaryService.deleteDiary(diaryNumber, userid);
    return response;
  }

}
