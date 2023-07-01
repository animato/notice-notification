package com.dsyang.noticenotification.app.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(@Param("name") String name);
    List<User> findByNameIn(List<String> nameList);
    List<User> findByIdIn(Set<Long> ids);
    boolean existsByName(@Param("name") String name);
    List<User> findAll();
}
