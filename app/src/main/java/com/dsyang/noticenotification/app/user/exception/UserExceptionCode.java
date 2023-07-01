package com.dsyang.noticenotification.app.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserExceptionCode {

    DUPLICATED_NAME(400, "U0000001", "이미 존재하는 사용자 입니다."),
    INVALID_NAME(400, "U0000002", "all 은 이름으로 사용할 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}
