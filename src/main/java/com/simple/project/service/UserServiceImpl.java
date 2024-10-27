package com.simple.project.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple.project.domain.User;
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
  public UserDTO insertUser(UserDTO userDTO) {
    User user = User.builder()
        .userId(userDTO.getUserId())
        .pw(userDTO.getPw())
        .build();

    User result = userRepository.save(user);
    return UserDTO.builder()
        .uno(result.getUno())
        .userId(result.getUserId())
        .pw(result.getPw())
        .build();
  }

  @Override
  public UserDTO getUserInfo(String userId) {
    Optional<User> result = userRepository.getUserInfo(userId);

    User user = result.orElseThrow();
    UserDTO userDTO = UserDTO.builder()
        .uno(user.getUno())
        .userId(user.getUserId())
        .pw(user.getPw())
        .build();

    return userDTO;
  }

}
