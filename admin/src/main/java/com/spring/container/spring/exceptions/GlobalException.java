package com.spring.container.spring.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> globalException(Exception e) {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> map = new HashMap<>();
    if(e instanceof TransactionException) {
      TransactionException except = (TransactionException)e;
      map.put("resuld_code", except.getResultCode());
      map.put("message", Arrays.asList(except.getMessage()));
    } else {
      map.put("result_code", 4000);
      map.put("messages", Arrays.asList(e.toString()));
    }
    map.put("payload", null);
    try {
      String json = mapper.writeValueAsString(map);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
    } catch (JsonProcessingException e1) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
  }

}
