package com.dsyang.noticenotification.app.user.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserException extends RuntimeException {
    final UserExceptionCode code;

    @Override
    public String getMessage() {
        return code.getMessage();
    }
    public int getStatus() {
        return code.getStatus();
    }
}
