package com.dsyang.noticenotification.app.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column("id")
    private Long id;
    private String name;

    @Embedded.Nullable
    private Contact contact;

    public User(String name, String type, String token, String channel) {
        this.name = name;
        this.contact = new Contact(type, token, channel);
    }
}
