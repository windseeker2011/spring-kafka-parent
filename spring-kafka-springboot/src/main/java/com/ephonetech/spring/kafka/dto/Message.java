package com.ephonetech.spring.kafka.dto;

import java.util.Date;

import com.ephonetech.spring.kafka.util.DateJsonDeserializer;
import com.ephonetech.spring.kafka.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class Message {

	private int id;

	private String message;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date time;

}
