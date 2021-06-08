package com.example.ticket.mapper;

import com.example.ticket.dto.TicketResponseDTO;
import com.example.ticket.entity.TicketEntity;

//@Mapper(componentModel = "spring")
public class TicketMapper {
	private TicketMapper() {
	}

	public static TicketResponseDTO ticketEntityToDTO(TicketEntity ticketEntity) {
		TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
		ticketResponseDTO.setName(ticketEntity.getName());
		ticketResponseDTO.setEmail(ticketEntity.getEmail());
		ticketResponseDTO.setShiftNumber(ticketEntity.getShiftNumber());
		ticketResponseDTO.setPrepaidType(ticketEntity.getPrepaidType());
		ticketResponseDTO.setAttentionType(ticketEntity.getAttentionType());
		ticketResponseDTO.setAttentionDate(ticketEntity.getAttentionDate());
		ticketResponseDTO.setStatus(ticketEntity.getStatus());
		return ticketResponseDTO;
	}

	public static TicketEntity ticketDTOToEntity(TicketResponseDTO ticketResponseDTO) {
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity.setName(ticketResponseDTO.getName());
		ticketEntity.setEmail(ticketResponseDTO.getEmail());
		ticketEntity.setShiftNumber(ticketResponseDTO.getShiftNumber());
		ticketEntity.setPrepaidType(ticketResponseDTO.getPrepaidType());
		ticketEntity.setAttentionType(ticketResponseDTO.getAttentionType());
		ticketEntity.setAttentionDate(ticketResponseDTO.getAttentionDate());
		ticketEntity.setStatus(ticketResponseDTO.getStatus());
		return ticketEntity;
	}
}
