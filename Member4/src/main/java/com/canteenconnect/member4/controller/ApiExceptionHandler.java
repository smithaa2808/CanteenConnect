package com.canteenconnect.member4.controller;
import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Map<String,String>> badRequest(IllegalArgumentException ex){return ResponseEntity.badRequest().body(Map.of("error",ex.getMessage()==null?"Invalid request":ex.getMessage()));}
 @ExceptionHandler(Exception.class) public ResponseEntity<Map<String,String>> serverError(Exception ex){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Unexpected server error"));}
}
