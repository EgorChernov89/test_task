package com.example.demoproject23333.dto.mapper;

import com.example.demoproject23333.dto.ResponseDto;
import com.example.demoproject23333.model.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MapperResponse {
    private final ModelMapper modelMapper;

    public Response convertToEntity(ResponseDto responseDto) {
        return Objects.isNull(responseDto) ? null : modelMapper.map(responseDto, Response.class);
    }
}
