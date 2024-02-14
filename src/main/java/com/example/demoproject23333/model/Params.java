package com.example.demoproject23333.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table (name = "params")
public class Params {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("CC.DevTime_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "devTimeTime")
	private LocalDateTime devTimeTime;

	@JsonProperty("CC.DevTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "devTime")
	private LocalDateTime devTime;

	@JsonProperty("CC.Latitude_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "latitudeTime")
	private LocalDateTime latitudeTime;

	@JsonProperty("CC.Latitude")
	@Column(name = "latitude")
	private String latitude;

	@JsonProperty("CC.Longitude_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "longitudeTime")
	private LocalDateTime longitudeTime;

	@JsonProperty("CC.Longitude")
	@Column(name = "longitude")
	private String longitude;

	@JsonProperty("CC.Course_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "courseTime")
	private LocalDateTime courseTime;

	@JsonProperty("CC.Course")
	@Column(name = "course")
	private String course;

	@JsonProperty("CC.Speed_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "speedTime")
	private LocalDateTime speedTime;

	@JsonProperty("CC.Speed")
	@Column(name = "speed")
	private String speed;

	@JsonProperty("CC.Status_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "statusTime")
	private LocalDateTime statusTime;

	@JsonProperty("CC.Status")
	@Column(name = "status")
	private String status;

	@JsonProperty("CC.BU_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "bUTime")
	private LocalDateTime bUTime;

	@JsonProperty("CC.BU")
	@Column(name = "bu")
	private String bu;

	@JsonProperty("CC.OUT_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "oUTTime")
	private LocalDateTime oUTTime;

	@JsonProperty("CC.OUT")
	@Column(name = "out")
	private String out;

	@JsonProperty("CC.T_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "tempTime")
	private LocalDateTime tempTime;

	@JsonProperty("CC.T")
	@Column(name = "temp")
	private String temp;

	@JsonProperty("CC.BZ_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "bZTime")
	private LocalDateTime bZTime;

	@JsonProperty("CC.BZ")
	@Column(name = "bz")
	private String bz;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "obj_params_id")
	@JsonIgnore
	private ObjParams objParams;
}