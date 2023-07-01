package com.dsyang.noticenotification.app.user.group;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Table("group_user")
@EqualsAndHashCode
@Getter
public class GroupUser {
    private final Long groupId;
    private final Long userId;

    public GroupUser(Long groupId, Long userId) {
        this.groupId = groupId;
        this.userId = userId;
    }
}
