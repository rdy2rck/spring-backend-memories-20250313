package com.sjh.memories_backend.common.dto.request.openai;

import java.util.List;

import com.sjh.memories_backend.common.vo.GptMessageVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestDto {
  private String model;
  private List<GptMessageVO> messages;  
}
