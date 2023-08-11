package com.spring.container.spring.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring.container.spring.enums.TokenEnum;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil{

  public String createToken(
    String id,
    String unique,
    int token_type,
    int type
  ) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    Date expireTime  = new Date();
    
    expireTime.setTime(expireTime.getTime() + 1000 * 3600 * 24); // (수정) 배포시 만료시간 30분

    String secretKeyEncodeBase64 = Encoders.BASE64.encode(
      type == TokenEnum.ACCESS_TOKEN.ordinal() ? 
      System.getenv("JWT_SECRET").getBytes() : 
      System.getenv("REFRESH_SECRET").getBytes()
    );
    byte[] keyBytes = Decoders.BASE64.decode(secretKeyEncodeBase64);
    Key key = Keys.hmacShaKeyFor(keyBytes);

    Map<String, Object> map = new HashMap<String, Object>();

    map.put("id", id);
    map.put("unique", unique);
    map.put("token_type", token_type);

    JwtBuilder builder = Jwts.builder()
      .setClaims(map);
    //테스트 계정은 access_token 만료가 없음
    if(token_type != 100) {
      builder.setExpiration(expireTime);
    }

    builder
      .setIssuer("booster")
      .signWith(key, signatureAlgorithm);

    return builder.compact();
  }
  public Claims verifyToken(String jwt , int type) throws UnsupportedEncodingException {
    String secretKeyEncodeBase64 = Encoders.BASE64.encode(
      TokenEnum.ACCESS_TOKEN.ordinal() == type ? 
      System.getenv("JWT_SECRET").getBytes() :
      System.getenv("REFRESH_SECRET").getBytes()
    );
    byte[] keyBytes = Decoders.BASE64.decode(secretKeyEncodeBase64);
    Key key = Keys.hmacShaKeyFor(keyBytes);
    try {
        Claims claims = Jwts.parser()
          .setSigningKey(key)
          .parseClaimsJws(jwt)
          .getBody();

        return claims;

    } catch (ExpiredJwtException e) {
        return null;
    } catch (Exception e) {
        return null;
    }
  }

}
