package com.spring.container.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.container.spring.enums.TokenEnum;
import com.spring.container.spring.utils.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class JwtInterceptor implements HandlerInterceptor{
  @Autowired
  private JwtUtil jwtUtil;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String authorizationHeader = request.getHeader("Authorization");
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      String jwtToken = authorizationHeader.substring(7);
      Claims claims = jwtUtil.verifyToken(jwtToken , TokenEnum.ACCESS_TOKEN.ordinal());
      request.setAttribute("id", claims.get("id"));
      request.setAttribute("unique", claims.get("unique"));
      request.setAttribute("token_type", claims.get("token_type"));
      return true;
    } else {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("Unauthorized");
      return false;
    }
  }
}
