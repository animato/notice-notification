package com.dsyang.noticenotification.app.user;

import com.dsyang.noticenotification.app.user.group.GroupManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    public static final String GROUP_PREFIX = "@@";
    public static final String USER_PREFIX = "@";
    final UserManager userManager;

    final GroupManager groupManager;

    public User create(String name, String type, String token, String channel) {
        return userManager.create(name, type, token, channel);
    }

    public Set<Contact> getTargetContact(List<String> list) {
        boolean all = list.stream().anyMatch(e -> e.equals("@all"));
        List<User> userList;
        if (all) {
            // all 인 경우
            userList = userManager.getAllUsers();
        } else {
            Map<Boolean, List<String>> map = list.stream().collect(Collectors.partitioningBy(e -> e.startsWith(GROUP_PREFIX)));
            List<String> groups = map.get(true).stream().map(s -> s.replaceFirst(GROUP_PREFIX, "")).collect(Collectors.toList());
            List<String> userNames = map.get(false).stream().map(s -> s.replaceFirst(USER_PREFIX, "")).collect(Collectors.toList());

            Set<Long> groupStream = groupManager.getGroupListByNameList(groups).stream().flatMap(g -> g.getMemberIdSet().stream())
                    .collect(Collectors.toSet());

            List<User> groupUsers = userManager.getUsersByIdSet(groupStream);
            List<User> users = userManager.getUserListByNameList(userNames);
            users.addAll(groupUsers);
            userList = users;
        }

        return userList.stream().map(User::getContact).collect(Collectors.toSet());
    }

}
