package com.example.demoproject23333.services;

import com.example.demoproject23333.dto.JwtAuthenticationResponse;
import com.example.demoproject23333.dto.SignInRequest;
import com.example.demoproject23333.dto.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);

}
