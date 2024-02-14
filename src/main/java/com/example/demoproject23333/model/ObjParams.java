package com.example.demoproject23333.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "obj_params")
public class ObjParams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("objId")
	@Column(name = "objId")
	private String objName;

	@JsonProperty("paramTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "paramTime")
	private LocalDateTime paramTime;

	@JsonProperty("params")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "params_id", referencedColumnName = "id")
	private Params params;
	@ManyToOne
	@JoinColumn(name = "response_id")
	@JsonIgnore
	private Response response;
}