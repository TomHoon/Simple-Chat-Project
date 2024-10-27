package com.simple.project.service;

import com.simple.project.domain.User;
import com.simple.project.dto.UserDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface UserService {
 UserDTO insertUser(UserDTO user);

 UserDTO getUserInfo(String id);
}
