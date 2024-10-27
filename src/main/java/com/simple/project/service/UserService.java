package com.simple.project.service;

import java.util.Map;

import com.simple.project.dto.UserDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface UserService {
 UserDTO register(UserDTO userDTO);

 UserDTO getUser(String userId);

 UserDTO updateUser(UserDTO userDTO);

 Map<Object, Boolean> deleteUser(Long uno);
}
