package com.dsyang.noticenotification.app.user.group;

import com.dsyang.noticenotification.app.user.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    final GroupManager groupManager;
    final UserManager userManager;

    /**
     * Group 생성
     * @return
     */
    public Group create(String name) {
        return groupManager.create(name);
    }

    public void joinGroup(String groupName, String userName) {
        Long userId = userManager.getByName(userName).getId();
        Group group = groupManager.getByName(groupName);
        group.joinUser(userId);
        groupManager.save(group);
    }

    public void leaveGroup(String groupName, String userName) {
        Long userId = userManager.getByName(userName).getId();
        Group group = groupManager.getByName(groupName);
        group.leaveUser(userId);
        groupManager.save(group);
    }
}
