package com.simple.project.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 빨간 줄 뜨면 
// 해당 위치로 커서 이동 > 'Quick Fix' > 'import ...' 클릭
@RestController
public class TestController {

 @GetMapping("/test")
 public Map<String, String> test() {
  return Map.of("test", "value");
 }
}
