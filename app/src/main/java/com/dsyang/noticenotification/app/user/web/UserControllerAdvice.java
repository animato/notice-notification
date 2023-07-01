package com.dsyang.noticenotification.app.user.web;

import com.dsyang.noticenotification.app.user.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<String> handler(UserException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
    }
}
