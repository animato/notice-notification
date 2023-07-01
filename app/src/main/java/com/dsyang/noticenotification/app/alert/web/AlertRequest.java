package com.dsyang.noticenotification.app.alert.web;

import lombok.Value;

import java.util.List;

@Value
public class AlertRequest {
    List<String> target;
    String severity;
    String message;
}
