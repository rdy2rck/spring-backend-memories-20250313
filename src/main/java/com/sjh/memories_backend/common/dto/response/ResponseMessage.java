package com.sjh.memories_backend.common.dto.response;

public interface ResponseMessage {
  String SUCCESS = "Success";

  String VALIDATION_FAIL = "Validation Fail.";
  String EXIST_USER = "Exist user.";
  String NO_EXIST_DIARY = "No Exist Diary";

  String SIGN_IN_FAIL = "Sign in Fail.";

  String NO_PERMISSION = "No Permission";

  String DATABASE_ERROR = "Database Error.";
  String OPEN_AI_ERROR = "Open AI Error";
}
