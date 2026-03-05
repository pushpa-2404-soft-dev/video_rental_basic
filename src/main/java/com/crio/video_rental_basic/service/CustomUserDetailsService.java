package com.crio.video_rental_basic.service;

import com.crio.video_rental_basic.repository.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    var user = userRepository
      .findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return new org.springframework.security.core.userdetails.User(
      user.getEmail(),
      user.getPassword(),
      Collections.singleton(
        new org.springframework.security.core.authority.SimpleGrantedAuthority(
          "ROLE_" + user.getRole()
        )
      )
    );
  }
}
