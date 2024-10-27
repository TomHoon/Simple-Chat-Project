package com.simple.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simple.project.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
 @EntityGraph(attributePaths = { "userRoleList" })
 @Query("select u from User u where u.uno = :uno")
 User getWithRoles(@Param("uno") Long uno);

 @Query("select u from User u where u.userId = :userId")
 Optional<User> getUserInfo(@Param("userId") String userId);

}
