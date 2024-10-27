package com.simple.project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.simple.project.dto.UserDTO;
import com.simple.project.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class UserController {

 private final UserService userService;

 @GetMapping("/getUserInfo")
 public UserDTO getUserInfo(@RequestParam String userId) {
  UserDTO userDTO = userService.getUserInfo(userId);

  return userDTO;
 }

 @PostMapping("/insertUser")
 public Long insertUser(@RequestBody UserDTO userDTO) {
  Long id = userService.insertUser(userDTO);
  return id;
 }

}
