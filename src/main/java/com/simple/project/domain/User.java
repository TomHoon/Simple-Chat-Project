package com.simple.project.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "userRoleList")
public class User {

 @Id
 private Long uno;

 private String userId;

 private String pw;

 @ElementCollection(fetch = FetchType.LAZY)
 @Builder.Default
 private List<UserRole> userRoleList = new ArrayList<>();

 public void addRole(UserRole userRole) {
  userRoleList.add(userRole);
 }

 public void clearRole() {
  userRoleList.clear();
 }

 public void changeUserId(String userId) {
  this.userId = userId;
 }

 public void changePw(String pw) {
  this.pw = pw;
 }

}
