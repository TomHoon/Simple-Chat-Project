package com.simple.project.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
 private Long uno;

 private String userId;

 private String pw;

 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
 private LocalDate dueDate;
}
