package com.simple.project.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple.project.domain.User;
import com.simple.project.domain.UserRole;
import com.simple.project.dto.UserDTO;
import com.simple.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDTO register(UserDTO userDTO) {
    User user = User.builder()
        .userId(userDTO.getUserId())
        .pw(userDTO.getPw())
        .build();

    user.addRole(UserRole.USER);

    User result = userRepository.save(user);

    log.info("result : " + result);

    return UserDTO.builder()
        .uno(result.getUno())
        .userId(result.getUserId())
        .pw(result.getPw())
        .build();
  }

  @Override
  public UserDTO getUser(String userId) {
    Optional<User> result = userRepository.getUser(userId);

    User user = result.orElseThrow();

    Long uno = user.getUno();
    Optional<User> test = userRepository.findById(uno);

    UserDTO userDTO = UserDTO.builder()
        .uno(user.getUno())
        .userId(user.getUserId())
        .pw(user.getPw())
        .build();

    return userDTO;
  }

  @Override
  public UserDTO updateUser(UserDTO userDTO) {
    Optional<User> result = userRepository.findById(userDTO.getUno());

    if (result.empty().isPresent()) {
      return null;
    }

    User saveUser = User.builder()
        .uno(userDTO.getUno())
        .userId(userDTO.getUserId())
        .pw(userDTO.getPw())
        .build();

    User savedResult = userRepository.save(saveUser);

    return UserDTO.builder()
        .uno(savedResult.getUno())
        .userId(savedResult.getUserId())
        .pw(savedResult.getPw())
        .build();

  }

  @Override
  public Map<Object, Boolean> deleteUser(Long uno) {
    userRepository.deleteById(uno);

    return Map.of("isDeleted", true);
  }

}
