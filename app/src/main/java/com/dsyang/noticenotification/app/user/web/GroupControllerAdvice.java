package com.dsyang.noticenotification.app.user.web;

import com.dsyang.noticenotification.app.user.exception.GroupException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GroupControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<String> handler(GroupException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
    }
}
