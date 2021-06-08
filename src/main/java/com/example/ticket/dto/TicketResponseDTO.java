package com.example.ticket.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TicketResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private Integer shiftNumber;
	private String prepaidType;
	private String attentionType;
	private LocalDate attentionDate;
	private Boolean status;

}
