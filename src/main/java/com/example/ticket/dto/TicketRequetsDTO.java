package com.example.ticket.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequetsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private Integer shiftNumber;
	private String prepaidType;
	private String attentionType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate attentionDate;
	private Boolean status;
}
