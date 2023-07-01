package com.dsyang.noticenotification.app.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GroupException extends RuntimeException {
    final GroupExceptionCode code;

    @Override
    public String getMessage() {
        return code.getMessage();
    }

    public int getStatus() {
        return code.getStatus();
    }
}
