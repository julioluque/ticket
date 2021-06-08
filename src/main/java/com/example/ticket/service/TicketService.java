package com.example.ticket.service;

import java.util.List;

import com.example.ticket.dto.TicketResponseDTO;
import com.example.ticket.entity.TicketEntity;

public interface TicketService {

	public List<TicketResponseDTO> findAll() throws Exception;

	public TicketEntity findById(Integer id) throws Exception;

	public void saveTicket(TicketEntity ticket) throws Exception;

	public void updateTicket(TicketEntity request);

	public void deleteTicketById(Integer id);
	
	public void deleteTicketByShiftNumber(Integer shiftNumber);
}
