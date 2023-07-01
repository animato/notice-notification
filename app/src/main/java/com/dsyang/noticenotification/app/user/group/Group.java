package com.dsyang.noticenotification.app.user.group;

import com.dsyang.noticenotification.app.user.exception.GroupException;
import com.dsyang.noticenotification.app.user.exception.GroupExceptionCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Table("group")
public class Group {

    @Id
    private Long id;

    private String name;

    @MappedCollection(idColumn = "group_id")
    private Set<GroupUser> member = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public void joinUser(Long userId) {
        GroupUser member = new GroupUser(this.id, userId);
        if (this.member.contains(member)) {
            throw new GroupException(GroupExceptionCode.ALREADY_MEMBER);
        } else {
            this.member.add(member);
        }
    }

    public void leaveUser(Long userId) {
        GroupUser member = new GroupUser(this.id, userId);
        this.member.remove(member);
    }

    public Set<Long> getMemberIdSet() {
        return this.member.stream().map(GroupUser::getUserId).collect(Collectors.toSet());
    }
}
