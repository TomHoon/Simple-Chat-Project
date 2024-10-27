package com.simple.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.project.domain.User;
import com.simple.project.domain.UserRole;
import com.simple.project.repository.UserRepository;
import com.simple.project.service.UserService;

@SpringBootTest
public class UserRepositoryTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Test
  public void testInsert() {
    for (int i = 0; i < 10; i++) {
      User user = User.builder()
          .uno((long) i)
          .userId("testId" + i)
          .pw("1234")
          .build();

      user.addRole(UserRole.USER);

      userRepository.save(user);
    }
  }
}
