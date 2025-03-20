package com.sjh.memories_backend.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_backend.common.dto.request.user.PatchUserRequestDto;
import com.sjh.memories_backend.common.dto.response.ResponseDto;
import com.sjh.memories_backend.common.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
  ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto, String userId);
}
