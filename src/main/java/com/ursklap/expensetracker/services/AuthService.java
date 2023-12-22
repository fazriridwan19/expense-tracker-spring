package com.ursklap.expensetracker.services;

import com.ursklap.expensetracker.models.CustomUserDetails;
import com.ursklap.expensetracker.models.Profile;
import com.ursklap.expensetracker.models.User;
import com.ursklap.expensetracker.models.dto.LoginDto;
import com.ursklap.expensetracker.models.dto.RegistrationDto;
import com.ursklap.expensetracker.repositories.ProfileRepository;
import com.ursklap.expensetracker.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {
  private CustomUserDetailsService userDetailsService;
  private ProfileService profileService;
  private PasswordEncoder passwordEncoder;
  private AuthenticationManager authenticationManager;
  private JwtService jwtService;
  private ModelMapper modelMapper;

  public Map<String, Object> registration(RegistrationDto registrationDto) {
    Profile profile = modelMapper.map(registrationDto, Profile.class);
    User user = modelMapper.map(registrationDto, User.class);
    user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
    user.setIsEnable(true);
    user.setProfile(profile);
    profile.setUser(user);
    profileService.create(profile);

    Map<String, Object> result = new HashMap<>();
    result.put("Success", true);
    result.put("Message", "User created");
    return result;
  }

  public Map<String, Object> login(LoginDto loginDto) {
    log.info("Logging in ...");
    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      loginDto.getUsername(),
                      loginDto.getPassword()
              )
      );
    } catch (AuthenticationException exception) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is not valid");
    }
    UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
    String token = jwtService.generateToken(userDetails);
    Map<String, Object> result = new HashMap<>();
    result.put("token", token);
    return result;
  }
}
