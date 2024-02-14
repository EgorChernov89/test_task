package com.example.demoproject23333.services;

import com.example.demoproject23333.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User save(User user);
    User create(User user);
    User getByUsername(String username);
    User getCurrentUser();

    UserDetailsService userDetailsService();
}
