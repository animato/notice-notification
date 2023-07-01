package com.dsyang.noticenotification.app.user.group;

import com.dsyang.noticenotification.app.user.exception.GroupException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GroupTest {

    @Test
    void joinUser() {
        Group group = GroupFactory.create("test_group");

        group.joinUser(1L);

        Set<Long> memberIdSet = group.getMemberIdSet();

        assertThat(memberIdSet).contains(1L);
    }

    @Test
    void alreadyMember() {
        Group group = GroupFactory.create("test_group");
        group.joinUser(1L);

        assertThatThrownBy(() -> {
            group.joinUser(1L);
        }).isInstanceOf(GroupException.class);
    }

    @Test
    void leaveUser() {
        Group group = GroupFactory.create("test_group");

        group.joinUser(1L);
        group.leaveUser(1L);

        Set<Long> memberIdSet = group.getMemberIdSet();

        assertThat(memberIdSet)
                .doesNotContain(1L);
    }
}