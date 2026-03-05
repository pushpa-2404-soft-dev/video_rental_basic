package com.crio.video_rental_basic.service;

import com.crio.video_rental_basic.dto.RegisterRequest;
import com.crio.video_rental_basic.entity.Role;
import com.crio.video_rental_basic.entity.User;
import com.crio.video_rental_basic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public String register(RegisterRequest request) {
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new RuntimeException("Email already exists");
    }

    Role role = request.getRole() != null ? request.getRole() : Role.CUSTOMER;

    User user = User.builder()
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .role(role)
      .build();

    userRepository.save(user);

    return "User registered successfully";
  }
}
