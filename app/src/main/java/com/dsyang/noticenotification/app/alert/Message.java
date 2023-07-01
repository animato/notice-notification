package com.dsyang.noticenotification.app.alert;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Message {

    private final String severity;
    private final String message;

    public String getFormattedMessage() {
        return String.format("[%s] %s", severity, message);
    }
}
