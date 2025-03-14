## DTO 패키지
각종 Controller 및 Service에서 사용되는 Dto 클래스가 위치하는 패키지
---
## 하위 클래스 설명

### response
- ResponseCode : 응답 코드 관리 클래스
- ResponseDto : 응답 제어 & 출력 담당 클래스
- ResponseMessage : 응답 메세지 관리 클래스

### response/auth
- SignUpResponseDto : 회원가입 시 응답 메세지 출력 담당 클래스

### request/auth
- IdCheckRequestDto : 아이디 중복 확인 관리 클래스
- SignUpRequestDto : 회원가입 정보 입력 시 제한사항 관리 클래스
- SignInRequestDto : 로그이 정보 입력 시 제한사항 관리 클래스