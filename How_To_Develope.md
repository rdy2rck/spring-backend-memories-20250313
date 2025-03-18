## WebSecurityConfig 보안 설정

## ID 중복 확인 알고리즘

## 응답 코드 & 메세지 관리 및 출력

## 회원가입 절차 & 중복 회원 여부 검사

## 로그인 절차 & 유효성 검사

## 네이버 & 카카오 SNS 로그인 기능
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

## 일기 모듈 생성
1. Service 폴더에 'DiaryService.java' 인터페이스, 'DiaryServiceImplement.java' 생성
2. 'DiaryServiceImplement.java'에 @Service 어노테이션 지정 후 controller 폴더에 'DiaryController.java' 생성 후 @RestController과 @RequestMapping 어노테이션 지정 후 DiaryService에 대한 의존성 주입(@RequiredArgsConstructor)
3. 'WebSecurityConfig.java'에서 diary에 대한 인가 설정 추가

## 일기 작성 기능 추가
1. dto/request 폴더에 diary 폴더 생성 후 'PostDiaryRequestDto.java' 생성
2. 'WebSecurityConfig.java'에 'AuthenticationFailEntryPoint' 클래스 생성을 포함한 인증 처리 또는 인증 실패에 대한 예외 처리 과정 작성
3. 'DiaryController.java'와 'DiaryService.java'에 일기 작성을 위한 API 컨트롤러 & 기능 정의 작성
4. 'DiaryServiceImplement.java'에 6번에서 생성한 기능의 비즈니스 로직 작성 후 'DiaryEntity.java'에서 입력 데이터를 엔터티로 변환하는 메서드 DiaryEntity 작성. 이후 'DiaryServiceImplement.java'에 엔터티를 DiaryRepository에 저장하도록 설정

## 일기 열람 기능 추가
1. vo 폴더에 'DiaryVO.java' 파일 생성 후 Diary의 엔터티들을 입력 후 @Getter 설정
2. DiaryVO 생성자를 이용해서 DiaryEntity의 엔터티를 이용해서 DiaryVO를 생성. 이후 DiaryVO를 리스트로 변환시키는 List<DiaryVO>를 생성
3. dto 폴더에 diary 폴더 생성 후 'GetMyDiaryResponseDto.java' 파일 생성.
4. 'DiaryService'와 'DiaryServiceImplement', 'DiaryRepository'에 List를 불러오는 메서드를 작성
5. 'DiaryController'에 불러온 List를 표시하는 메서드 작성하여 내 일기를 불러오는 기능 완성
6. dto/diary 폴더에 'GetDiaryResponseDto.java' 생성
7. ResponseCode.java, ResponseMessage.java, ResponseDto.java 에 일기가 존재하지 않을 시의 에러 메세지 생성 후 추가
8. 'DiaryService.java'와 'DiaryServiceImplement.java'에 추가한 후 DiaryRepository에 일기 숫자로 일기 'DiaryController.java'에