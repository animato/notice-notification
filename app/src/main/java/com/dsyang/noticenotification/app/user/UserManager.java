package com.dsyang.noticenotification.app.user;

import com.dsyang.noticenotification.app.user.exception.UserException;
import com.dsyang.noticenotification.app.user.exception.UserExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserManager {
    final UserRepository repository;

    /**
     * user 가입
     * @return
     */
    public User create(String name, String type, String token, String channel) {
        if (repository.existsByName(name)) {
            throw new UserException(UserExceptionCode.DUPLICATED_NAME);
        }

        if ("all".equals(name)) {
            throw new UserException(UserExceptionCode.INVALID_NAME);
        }

        User user = new User(name, type, token, channel);
        repository.save(user);
        return user;
    }

    public User getByName(String userName) {
        return repository.findByName(userName).orElseThrow();
    }

    public List<User> getUserListByNameList(List<String> userName) {
        return repository.findByNameIn(userName);
    }

    public List<User> getUsersByIdSet(Set<Long> idSet) {
        return repository.findByIdIn(idSet);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
