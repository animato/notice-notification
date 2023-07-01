package com.dsyang.noticenotification.app.user.web;

import com.dsyang.noticenotification.app.user.group.Group;
import com.dsyang.noticenotification.app.user.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
public class GroupController {
    final GroupService groupService;

    /**
     * 알람 그룹 생성
     *
     * @param request
     * @return
     */
    @PostMapping("/create")
    public Group create(@RequestBody GroupCreateRequest request) {
        Group group = groupService.create(request.getName());
        return group;
    }

    @PostMapping("/join")
    public void join(@RequestBody GroupJoinRequest request) {
        groupService.joinGroup(request.getGroupName(), request.getNickname());
    }

    @PostMapping("/leave")
    public void leave(@RequestBody GroupLeaveRequest request) {
        groupService.leaveGroup(request.getGroupName(), request.getNickname());
    }
}
