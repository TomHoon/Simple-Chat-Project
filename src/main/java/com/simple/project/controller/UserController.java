package com.simple.project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.simple.project.dto.UserDTO;
import com.simple.project.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

 private final UserService userService;

 @GetMapping("/{userId}")
 public UserDTO getUser(@PathVariable(name = "userId") String userId) {
  UserDTO userDTO = userService.getUser(userId);

  return userDTO;
 }

 @PostMapping("/register")
 public UserDTO register(@RequestBody UserDTO userDTO) {
  UserDTO resultDTO = userService.register(userDTO);
  return resultDTO;
 }

 @PutMapping("/update")
 public UserDTO updateUser(@RequestBody UserDTO userDTO) {
  UserDTO resultDTO = userService.updateUser(userDTO);

  return resultDTO;
 }

 @DeleteMapping("/delete/{uno}")
 public Map<Object, Boolean> deleteUser(@PathVariable("uno") Long uno) {
  Map<Object, Boolean> result = userService.deleteUser(uno);

  return result;
 }

}
