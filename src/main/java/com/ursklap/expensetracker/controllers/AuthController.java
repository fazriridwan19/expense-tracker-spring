package com.ursklap.expensetracker.controllers;

import com.ursklap.expensetracker.models.User;
import com.ursklap.expensetracker.models.dto.LoginDto;
import com.ursklap.expensetracker.models.dto.RegistrationDto;
import com.ursklap.expensetracker.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
  private AuthService authService;

  @PostMapping("/registration")
  public ResponseEntity<Map<String, Object>> registration(@RequestBody RegistrationDto registrationDto) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(authService.registration(registrationDto));
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginDto) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(authService.login(loginDto));
  }
}
