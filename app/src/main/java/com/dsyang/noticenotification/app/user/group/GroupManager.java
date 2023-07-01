package com.dsyang.noticenotification.app.user.group;

import com.dsyang.noticenotification.app.user.exception.GroupException;
import com.dsyang.noticenotification.app.user.exception.GroupExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupManager {
    final GroupRepository repository;

    /**
     * Group 생성
     * @return
     */
    public Group create(String name) {
        if (repository.existsByName(name)) {
            throw new GroupException(GroupExceptionCode.DUPLICATED_NAME);
        }

        if ("all".equals(name)) {
            throw new GroupException(GroupExceptionCode.INVALID_NAME);
        }

        Group group = new Group(name);
        return repository.save(group);
    }

    public Group getByName(String groupName) {
        return repository.findByName(groupName).orElseThrow();
    }

    public List<Group> getGroupListByNameList(List<String> groupName) {
        return repository.findByNameIn(groupName);
    }

    public Group save(Group group) {
        return repository.save(group);
    }
}
