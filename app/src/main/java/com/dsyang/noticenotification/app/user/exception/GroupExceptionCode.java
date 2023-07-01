package com.dsyang.noticenotification.app.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GroupExceptionCode {

    DUPLICATED_NAME(400, "G0000001", "이미 존재하는 그룹 입니다."),
    INVALID_NAME(400, "G0000002", "all 은 그룹 이름으로 사용할 수 없습니다."),
    ALREADY_MEMBER(400, "G0000003", "이미 가입된 사용자 입니다");

    private final int status;
    private final String code;
    private final String message;
}
