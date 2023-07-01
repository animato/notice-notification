package com.dsyang.noticenotification.app.alert;

import lombok.Value;

@Value
public class QueueData {
    String token;
    String channel;
    String text;
}
