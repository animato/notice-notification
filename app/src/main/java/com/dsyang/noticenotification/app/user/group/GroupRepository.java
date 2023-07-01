package com.dsyang.noticenotification.app.user.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group, Long> {
    Optional<Group> findByName(@Param("name") String name);
    List<Group> findByNameIn(List<String> nameList);
    boolean existsByName(@Param("name") String name);
}
