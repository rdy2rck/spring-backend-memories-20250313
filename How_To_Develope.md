### WebSecurityConfig 보안 설정

### ID 중복 확인 알고리즘

### 응답 코드 & 메세지 관리 및 출력

### 회원가입 절차 & 중복 회원 여부 검사

### 로그인 절차 & 유효성 검사

### 네이버 & 카카오 SNS 로그인 기능
1. 카카오 & 네이버 디벨로퍼즈의 '내 어플리케이션'에서 사용 API '로그인', 'Web'으로 어플리케이션 생성
2. application.properties에 카카오 & 네이버 OAuth2 설정 & 프로바이더 설정 의존성 추가
3. 2번에서 추가한 의존성에서 카카오 & 네이버 디벨로퍼즈에서 구한 클라이언트 ID & 시크릿 키 적용
4. 카카오 & 네이버 디벨로퍼즈의 '동의 항목'에서 2번에서 추가한 의존성에 있는 개인정보 동의 항목을 '필수 동의'로 전환
5. entity 폴더에 'CustomOAuth2User.java' 파일 생성 후 OAuth2 유저 객체 생성 및 회원가입 여부 코드 작성
6. service/implement 폴더에 'OAuth2UserServiceImplement.java' 파일 생성 후 유저 정보에서 ID 값을 추출하는 코드 작성 & UserRepository에 SNS 로그인 관련 코드 삽입
7. 'WebSecurityConfig.java' 파일에 OAuth 로그인 적용 코드 삽입
8. handler 폴더에 'OAuth2SuccessHandler.java' 파일 생성 후 OAuth2 유저 서비스 작업 성공 시 페이지 리다이렉트, 쿠키 설정 코드를 작성
9. 'WebSecurityConfig.java'에 7번에서 작성한 코드의 userInfoEndpoint 코드에 'OAuth2SuccessHandler.java' 설정을 추가
10. 'SignUpRequestDto.java'와 'UserEntity.java'에 SNS ID 엔티티 추가
11. 'application.properties'에 OAuth 클라이언트 주소 설정
12. 'OAuth2SuccessHandler.java'에 11번에서 설정한 주소로 oAuthClientMain과 oAuthClientAuth 변수 설정 후 sendRedirect에 할당

### 일기 모듈 생성
1. Service 폴더에 'DiaryService.java' 인터페이스, 'DiaryServiceImplement.java' 생성
2. 'DiaryServiceImplement.java'에 @Service 어노테이션 지정 후 controller 폴더에 'DiaryController.java' 생성 후 @RestController과 @RequestMapping 어노테이션 지정 후 DiaryService에 대한 의존성 주입(@RequiredArgsConstructor)
3. 'WebSecurityConfig.java'에서 diary에 대한 인가 설정 추가

### 일기 작성 기능 추가
1. dto/request 폴더에 diary 폴더 생성 후 'PostDiaryRequestDto.java' 생성
2. 'WebSecurityConfig.java'에 'AuthenticationFailEntryPoint' 클래스 생성을 포함한 인증 처리 또는 인증 실패에 대한 예외 처리 과정 작성
3. 'DiaryController.java'와 'DiaryService.java'에 일기 작성을 위한 API 컨트롤러 & 기능 정의 작성
4. 'DiaryServiceImplement.java'에 6번에서 생성한 기능의 비즈니스 로직 작성 후 'DiaryEntity.java'에서 입력 데이터를 엔터티로 변환하는 메서드 DiaryEntity 작성. 이후 'DiaryServiceImplement.java'에 엔터티를 DiaryRepository에 저장하도록 설정

### 일기 열람 기능 추가
1. vo 폴더에 'DiaryVO.java' 파일 생성 후 Diary의 엔터티들을 입력 후 @Getter 설정
2. DiaryVO 생성자를 이용해서 DiaryEntity의 엔터티를 이용해서 DiaryVO를 생성. 이후 DiaryVO를 리스트로 변환시키는 List<DiaryVO>를 생성
3. dto 폴더에 diary 폴더 생성 후 'GetMyDiaryResponseDto.java' 파일 생성.
4. 'DiaryService'와 'DiaryServiceImplement', 'DiaryRepository'에 List를 불러오는 메서드를 작성
5. 'DiaryController'에 불러온 List를 표시하는 메서드 작성하여 내 일기를 불러오는 기능 완성
6. dto/diary 폴더에 'GetDiaryResponseDto.java' 생성
7. ResponseCode.java, ResponseMessage.java, ResponseDto.java 에 일기가 존재하지 않을 시의 에러 메세지 생성 후 추가
8. 'DiaryService.java'와 'DiaryServiceImplement.java'에 추가한 후 DiaryRepository에 일기 숫자로 일기 'DiaryController.java'에

### 일기 수정 기능 추가
1. request/diary 폴더에서 PatchDiaryRequestDto.java 파일 생성
2. ResponseCode.java, esponseMessage.java, ResponseDto.java에 일기 수정 권한이 없을 시의 에러 메세지 생성 후 추가
3. DiaryService.java에 일기 수정 기능 정의 후, DiaryServiceImplement.java에 비즈니스 로직 생성
4. DiaryEntity.java에 일기 수정(patch) 메서드 추가한 후 DiaryServiceImplement.java에 DiaryEntity에서 수정한 내용을 추가
5. DiaryController.java에서 일기 수정을 위한 API 요청 처리 기능 추가

### 일기 삭제 기능 추가
1. DiaryService.java에 일기 삭제 기능을 정의한 후 DiaryServiceImplement.java에 비즈니스 로직 생성
2. DiaryController.java에서 일기 삭제를 위한 API 요청 처리 기능 추가

### 로그인 유저 정보 관리 기능 추가 (2025-03-20 14:50, 15:50)
1. UserController.java, UserService.java, UserRepository.java 파일 생성
2. UserService.java에서 사용자 정보를 불러오는 기능인 getSignInUser와 사용자 정보를 수정하는 기능인 patchUser 정의
3. UserServiceImplement.java에서 2번에서 정의한 기능의 비즈니스 로직 구현. getSignInUser 메서드를 통해 UserRepository에서 사용자 정보를 조회한 후 GetSignInUserReponseDto로 반환
4. 같은 파일에서 patchUser 메서드를 통해 PatchUserRequestDto로 수정할 데이터를 받은 뒤 UserRepository에서 사용자 정보를 찾은 후 UserEntity의 patch() 메서드로 PatchUserRequestDto의 데이터를 반영 후 데이터베이스에 저장한 뒤 응답
5. UserController.java에서 @GetMapping("/sign-in") 메서드로 사용자 정보 불러오기, @PatchMapping({"", "/"}) 메서드로 사용자 정보 수정에 필요한 API 엔드포인트 정의

### 기억력 테스트 결과 데이터 저장 (2025-03-21 09:50, 10:50)
1. TestService.java와 TestServiceImplement.java, TestController.java 생성
2. dto/request 폴더와 dto/response 폴더 아래에 각각 test 폴더 생성 후 dto/request/test 폴더 아래에 PostMemoryRequestDto.java 파일 생성, DB에 측정 시간 요청
3. TestService에 기억력 테스트 결과 저장 기능 정의 후 TestServiceImplement에 비즈니스 로직 작성
4. MemoryTestEntity로 사용자 ID과 최초 테스트 결과, 두 번째 테스트 이후 테스트 결과 엔터티 생성 후 MemoryTestRepository에서 사용자 ID과 테스트 결과를 저장
5. TestController에 @PostMapping("/memory") 메서드로 검사 결과 저장에 필요한 API 엔드포인트 정의

### 기억력 테스트 결과 불러오기 (2025-03-21 10:50)
1. vo 폴더 아래에 MemoryTestVO.java 생성 후 MemoryTestEntity의 엔터티를 이용해 MemoryTestVO를 생성 후 리스트로 변환
2. response/test 폴더 아래에 GetMemoryResponseDto.java 생성 후 DB에 기억력 테스트 결과를 불러오도록 호출
3. TestSerivce에 기억력 테스트 검사 결과 불러오기 기능 정의한 뒤 TestServiceImplement에 비즈니스 로직 작성
4. MemoryTestRepository에서 기억력 테스트 결과를 사용자 최근에 한 테스트 결과 순서대로 불러오도록 지정
5. TestController에 @GetMapping("/memory") 메서드로 검사 결과 조회에 필요한 API 엔드포인트 정의

### 집중력 테스트 결과 데이터 저장 (2025-03-24 09:50)
1. dto/request 폴더와 dto/response 폴더 아래에 각각 test 폴더 생성 후 dto/request/test 폴더 아래에 PostConcentrationRequestDto.java 파일 생성, DB에 측정 시간 요청
2. TestService에 집중력 테스트 결과 저장 기능 정의 후 TestServiceImplement에 비즈니스 로직 작성
3. ConcentrationTestEntity로 사용자 ID과 최초 테스트 결과, 두 번째 테스트 이후 테스트 결과 엔터티 생성 후 ConcentrationTestRepository에서 사용자 ID과 테스트 결과를 저장
4. TestController에 @PostMapping("/concentration") 메서드로 검사 결과 저장에 필요한 API 엔드포인트 정의

### 집중력 테스트 결과 불러오기 (2025-03-24 10:50)
1. vo 폴더 아래에 ConcentrationTestVO.java 생성 후 ConcentrationTestEntity의 엔터티를 이용해 ConcentrationTestVO를 생성 후 리스트로 변환
2. response/test 폴더 아래에 GetConcentrationResponseDto.java 생성 후 DB에 기억력 테스트 결과를 불러오도록 호출
3. TestSerivce에 기억력 테스트 검사 결과 불러오기 기능 정의한 뒤 TestServiceImplement에 비즈니스 로직 작성
4. ConcentrationTestRepository에서 기억력 테스트 결과를 사용자 최근에 한 테스트 결과 순서대로 불러오도록 지정
5. TestController에 @GetMapping("/Concentration") 메서드로 검사 결과 조회에 필요한 API 엔드포인트 정의