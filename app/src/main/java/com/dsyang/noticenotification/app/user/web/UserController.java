package com.dsyang.noticenotification.app.user.web;

import com.dsyang.noticenotification.app.user.User;
import com.dsyang.noticenotification.app.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    /**
     * 사용자 생성
     *
     * @param request
     * @return
     */
    @PostMapping("/create")
    public User create(@RequestBody UserCreateRequest request) {
        User user = userService.create(request.getName(), request.getContact().getType(), request.getContact().getToken(), request.getContact().getChannel());
        return user;
    }
}
