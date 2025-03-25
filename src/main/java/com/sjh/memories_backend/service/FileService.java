package com.sjh.memories_backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  
  String upload(MultipartFile file);
  Resource getImageFile(String fileName);
  
}
