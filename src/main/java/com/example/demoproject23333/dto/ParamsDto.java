package com.example.demoproject23333.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "преобразование полученных данных в DTO")
public class ParamsDto {

    @JsonProperty("CC.DevTime_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime devTimeTime;

    @JsonProperty("CC.DevTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime devTime;

    @JsonProperty("CC.Latitude_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime latitudeTime;

    @JsonProperty("CC.Latitude")
    private String latitude;

    @JsonProperty("CC.Longitude_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime longitudeTime;

    @JsonProperty("CC.Longitude")
    private String longitude;

    @JsonProperty("CC.Course_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime courseTime;

    @JsonProperty("CC.Course")
    private String course;

    @JsonProperty("CC.Speed_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime speedTime;

    @JsonProperty("CC.Speed")
    private String speed;

    @JsonProperty("CC.Status_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime statusTime;

    @JsonProperty("CC.Status")
    private String status;

    @JsonProperty("CC.BU_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime bUTime;

    @JsonProperty("CC.BU")
    private String bu;

    @JsonProperty("CC.OUT_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime oUTTime;

    @JsonProperty("CC.OUT")
    private String out;

    @JsonProperty("CC.T_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime tempTime;

    @JsonProperty("CC.T")
    private String temp;

    @JsonProperty("CC.BZ_Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime bZTime;

    @JsonProperty("CC.BZ")
    private String bz;


}

