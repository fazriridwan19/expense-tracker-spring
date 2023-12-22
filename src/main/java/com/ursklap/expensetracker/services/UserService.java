package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.User;
import com.ursklap.expensetracker.repositories.UserRepository;
import com.ursklap.expensetracker.services.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService extends BaseService<User, Long> {
  private UserRepository userRepository;

  public User getCurrentUser() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not found"));
  }
}
