package com.dsyang.noticenotification.app.user;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

public class UserFactory {

    public static User create(Long id, String name, String type) {
        String token = UUID.randomUUID().toString();
        String channel = UUID.randomUUID().toString();
        User user = new User(name, type, token, channel);
        ReflectionTestUtils.setField(user, "id", id);
        return user;
    }
}
