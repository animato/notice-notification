package com.dsyang.noticenotification.app.user;

import com.dsyang.noticenotification.app.user.group.Group;
import com.dsyang.noticenotification.app.user.group.GroupFactory;
import com.dsyang.noticenotification.app.user.group.GroupManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserManager userManager;

    @Mock
    private GroupManager groupManager;

    @InjectMocks
    private UserService userService;

    @Test
    void getTargetContact() {
        List<String> list = List.of("@test1", "@@testgroup", "@all");

        List<User> allUsers = List.of(
                UserFactory.create(1L, "test1", "slack"),
                UserFactory.create(2L, "test2", "telegram"),
                UserFactory.create(3L, "test3", "slack"),
                UserFactory.create(4L, "test4", "telegram"),
                UserFactory.create(5L, "test5", "slack")
        );
        Set<Contact> contactSet = allUsers.stream().map(User::getContact).collect(Collectors.toSet());

        when(userManager.getAllUsers()).thenReturn(allUsers);

        Set<Contact> targetContact = userService.getTargetContact(list);

        assertThat(targetContact)
                .containsExactlyElementsOf(contactSet);
    }

    @Test
    void getTargetContact2() {
        User user1 = UserFactory.create(1L, "test1", "slack");
        User user2 = UserFactory.create(2L, "test2", "telegram");
        User user3 = UserFactory.create(3L, "test3", "slack");
        User user4 = UserFactory.create(4L, "test4", "telegram");
        User user5 = UserFactory.create(5L, "test5", "slack");

        List<User> userList = List.of(user1, user2, user3, user4, user5);

        Group group1 = GroupFactory.create("group1");
        Group group2 = GroupFactory.create("group2");

        List<Group> groupList = List.of(group1, group2);

        group1.joinUser(1L);
        group1.joinUser(2L);
        group1.joinUser(3L);

        group2.joinUser(4L);
        group2.joinUser(5L);

        when(userManager.getUserListByNameList(anyList())).thenAnswer((Answer<List<User>>) invocation -> {
            List<String> argument = invocation.getArgument(0);
            return userList.stream().filter(u -> argument.contains(u.getName())).collect(Collectors.toList());
        });
        when(groupManager.getGroupListByNameList(anyList())).thenAnswer((Answer<List<Group>>) invocation -> {
            List<String> argument = invocation.getArgument(0);
            return groupList.stream().filter(u -> argument.contains(u.getName())).collect(Collectors.toList());
        });
        when(userManager.getUsersByIdSet(anySet())).thenAnswer((Answer<List<User>>) invocation -> {
            Set<Long> argument = invocation.getArgument(0);
            return userList.stream().filter(u -> argument.contains(u.getId())).collect(Collectors.toList());
        });

        List<String> list = List.of("@test1", "@@group2");

        Set<Contact> targetContact = userService.getTargetContact(list);

        assertThat(targetContact)
                .containsExactlyInAnyOrder(
                        user1.getContact(),
                        user4.getContact(),
                        user5.getContact());
    }
}