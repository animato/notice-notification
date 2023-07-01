package com.dsyang.noticenotification.app.user.group;

public class GroupFactory {

    public static Group create(String name) {
        return new Group(name);
    }
}
