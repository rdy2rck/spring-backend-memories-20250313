package com.sjh.memories_backend.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_backend.common.dto.request.auth.IdCheckRequestDto;
import com.sjh.memories_backend.common.dto.request.auth.SignInRequestDto;
import com.sjh.memories_backend.common.dto.request.auth.SignUpRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.dto.response.auth.SignInResponseDto;

// function: 회원 인증(Authorization) 기능 정의 //
public interface AuthService {
  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
