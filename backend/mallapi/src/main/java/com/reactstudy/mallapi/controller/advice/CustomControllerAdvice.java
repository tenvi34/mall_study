package com.reactstudy.mallapi.controller.advice;

import java.util.NoSuchElementException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// 페이지 번호를 숫자가 아닌 문자로 전달하면 발생하는 에러를 예외 처리하기 위해
@RestController
public class CustomControllerAdvice {
    
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<?> notExit(NoSuchElementException e) {

        String message = e.getMessage();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleIllegalArgumentException(MethodArgumentNotValidException e) {

        String message = e.getMessage();

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Map.of("message", message));
    }

}
