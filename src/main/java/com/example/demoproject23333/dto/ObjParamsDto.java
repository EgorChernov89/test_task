package com.example.demoproject23333.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "преобразование полученных данных в DTO")
public class ObjParamsDto {

    @JsonProperty("objId")
    private String objName;

    @JsonProperty("paramTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime paramTime;

    @JsonProperty("params")
    private ParamsDto params;

}
