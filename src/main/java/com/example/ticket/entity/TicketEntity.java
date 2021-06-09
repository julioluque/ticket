package com.example.ticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TICKET")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "numero_turno", nullable = false)
	private Integer shiftNumber;

	@Column(name = "tipo_prepaga", nullable = false)
	private String prepaidType;

	@Column(name = "tipo_atencion", nullable = false)
	private String attentionType;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "fecha_turno", nullable = false)
	private LocalDate attentionDate;

	@Column(name = "estado_turno", nullable = false)
	private Boolean status;

}
