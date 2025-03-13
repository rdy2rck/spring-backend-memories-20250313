package com.sjh.memories_backend.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sjh.memories_backend.MemoriesBackendApplication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// class: JWT 생성 및 검증 기능 제공자 //
// description: JWT 암호화 알고리즘 //
// description: 암호화에 사용되는 Secret Key는 환경 변수의 jwt.secret 사용 //
// description: JWT 만료 기간 9시간 //
@Component
public class JwtProvider {
  
  //@Value("${Secret Key 변수}") 입력 시 application.properties에 등록해둔 JWT 비밀키 사용 가능
  @Value("${jwt.secret}")
  private String secretKey;

  // function: JWT 생성 메서드 //
  // description: 생성되는 JWT의 payload에는 sub, iat, exp 값이 들어가도록 함 //
  // description: sub - 사용자의 아이디, iat - 생성 시 시간, exp - 생성시간 + 9시간 //
  public String create(String userId) {

    Date expiration = Date.from(Instant.now().plus(0, ChronoUnit.HOURS));

    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    String jwt = null;

    try {

      jwt = Jwts.builder()
        .signWith(key, SignatureAlgorithm.HS256)
        .setSubject(userId) 
        .setIssuedAt(new Date()) // 생성 기간 (현재 시간 기준)
        .setExpiration(expiration) // 만료 기간
        .compact(); // 입축 & 인코딩

    } catch (Exception exception) {
      exception.printStackTrace();
    }

    return jwt;

  }

  // function: JWT 검증 메서드 //
  // description: 검증이 성공적으로 완료되면 subject에 있는 userId 반환 //
  public String validate(String jwt) {

    String userId = null;

    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    try {

      userId = Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(jwt)
        .getBody() // Body 값을 가져옴
        .getSubject(); // Subject 값을 가져옴

    } catch(Exception exception) {
      exception.printStackTrace();
    }

    return userId;

  }

}
