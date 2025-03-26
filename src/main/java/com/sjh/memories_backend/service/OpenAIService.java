package com.sjh.memories_backend.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_backend.common.dto.request.openai.GetWayRequestDto;
import com.sjh.memories_backend.common.dto.response.openai.GetWayResponseDto;

public interface OpenAIService {
  ResponseEntity<? super GetWayResponseDto> getWay(GetWayRequestDto dto, String userId);
}
