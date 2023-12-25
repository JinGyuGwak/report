package com.example.outlier.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> IllegalArgumentExceptionHandle(IllegalArgumentException exception, WebRequest webRequest) {
        log.warn("IllegalArgumentException. error message: {}", exception.getMessage());
        return new org.springframework.http.ResponseEntity<>(
                ExceptionRes.builder()
                        .status(400)
                        .timestamp(LocalDateTime.now())
                        .message(exception.getMessage())
                        .details(webRequest.getDescription(true))
                        .build()
                , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> ValidExceptionHandle(Exception exception, WebRequest webRequest) {
        log.error("ValidException has occured. ", exception);
        return new org.springframework.http.ResponseEntity<>(
                ExceptionRes.builder()
                        .status(400)
                        .timestamp(LocalDateTime.now())
                        .message(exception.getMessage())
                        .details(webRequest.getDescription(true))
                        .build()
                ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> SQLExceptionHandle(Exception exception, WebRequest webRequest) {
        log.error("SQLIntegrityConstraintViolationException has occured. ", exception);
        return new org.springframework.http.ResponseEntity<>(
                ExceptionRes.builder()
                        .status(400)
                        .timestamp(LocalDateTime.now())
                        .message("데이터베이스에 잘못된 접근을 하였습니다.")
                        .details(webRequest.getDescription(true))
                        .build()
                ,HttpStatus.BAD_REQUEST);
    }
}
