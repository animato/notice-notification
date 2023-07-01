package com.dsyang.noticenotification.app.user.web;

import lombok.Value;

@Value
public class UserCreateRequest {
    String name;
    ContactRequest contact;
    @Value
    public static class ContactRequest {
        String type;
        String token;
        String channel;
    }
}
