package com.crio.video_rental_basic.controller;

import com.crio.video_rental_basic.dto.RegisterRequest;
import com.crio.video_rental_basic.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public String register(@RequestBody RegisterRequest request) {
    return authService.register(request);
  }
}
