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