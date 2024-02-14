package com.example.demoproject23333.controller;


import com.example.demoproject23333.dto.mapper.MapperResponse;
import com.example.demoproject23333.model.Response;
import com.example.demoproject23333.dto.ResponseDto;
import com.example.demoproject23333.services.Impl.ObjParamsServiceImpl;
import com.example.demoproject23333.services.ObjParamsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/rest/v2")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class RestfullController {

    private final ObjParamsService objParamsService;
    private final MapperResponse mapperResponse;



    @PostMapping("/putRawParams")
    @Operation(summary = "метод для записи полученных данных устройства в БД")
    public Response getRawParams(@RequestBody ResponseDto responseDto) {
        return objParamsService.saveResponseFromJson(mapperResponse.convertToEntity(responseDto));
    }

    @GetMapping("/convert")
    @Operation(summary = "преобразование полученных данных о статусе устройства")
    public String convertStatus(@RequestParam String objName) {
        String statusText = objParamsService.convertStatus(objName);
        return statusText;
    }

    @GetMapping("/calculateAverageSpeed")
    @Operation(summary = "Вычисление средней скорости по одному устройству по полученным значениям за период определеный период")
    public String calculateAverageSpeed(@RequestParam String objName, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return objParamsService.calculateAverageSpeed(objName, startDate, endDate);
    }

}
