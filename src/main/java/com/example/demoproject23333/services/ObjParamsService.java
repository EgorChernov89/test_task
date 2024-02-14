package com.example.demoproject23333.services;

import com.example.demoproject23333.dto.ResponseDto;
import com.example.demoproject23333.model.Params;
import com.example.demoproject23333.model.Response;

import java.time.LocalDate;

public interface ObjParamsService {
    String convertStatus(String objName);
    Response saveResponseFromJson(Response response);
    String calculateAverageSpeed(String objName, LocalDate startDate, LocalDate endDate);
}
