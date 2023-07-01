package com.dsyang.noticenotification.app.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String type;
    private String token;
    private String channel;
}
