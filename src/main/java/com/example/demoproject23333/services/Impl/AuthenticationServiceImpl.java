package com.example.demoproject23333.services.Impl;

import com.example.demoproject23333.dto.JwtAuthenticationResponse;
import com.example.demoproject23333.dto.SignInRequest;
import com.example.demoproject23333.dto.SignUpRequest;
import com.example.demoproject23333.model.User;
import com.example.demoproject23333.model.enums.Role;
import com.example.demoproject23333.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Сервис аутентификации, реализующий методы для регистрации и входа в систему
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserServiceImpl userService;
    private final JwtServiceImpl jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    //Регистрация нового пользователя
    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        userService.create(user);
        // Генерируем токен и возвращаем его в ответе
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
    //Вход пользователя в систему
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        // Аутентификация пользователя по его данным
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        // Загружаем детали пользователя
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());
        // Генерируем токен и возвращаем его в ответе
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
