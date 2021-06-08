package com.example.ticket.mapper;

import com.example.ticket.dto.TicketResponseDTO;
import com.example.ticket.entity.TicketEntity;

//@Mapper(componentModel = "spring")
public class TicketMapper {
	private TicketMapper() {
	}

	public static TicketResponseDTO ticketEntityToDTO(TicketEntity ticketEntity) {
		TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
		ticketResponseDTO.setAttentionDate(ticketEntity.getAttentionDate());
		return ticketResponseDTO;
	}
}
