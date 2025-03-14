package com.sjh.memories_backend.common.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sjh.memories_backend.common.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto extends ResponseDto {

  private String accessToken;
  private Integer expiration;

  private SignUpResponseDto(String accessToken) {
    this.accessToken = accessToken;
    this.expiration = 60 * 60 * 9;
  }

  public static ResponseEntity<SignUpResponseDto> success(String accessToken) {
    SignUpResponseDto body = new SignUpResponseDto(accessToken);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
  
}
