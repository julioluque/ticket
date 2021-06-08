package com.example.ticket.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket.dto.TicketResponseDTO;
import com.example.ticket.entity.TicketEntity;
import com.example.ticket.mapper.TicketMapper;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.service.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;

	@Override
	public List<TicketResponseDTO> findAll() throws Exception {
		List<TicketResponseDTO> ticketList = repository.findAll().stream().map(TicketMapper::ticketEntityToDTO)
				.collect(Collectors.toList());
		return ticketList;
	}

	@Override
	public TicketEntity findById(Integer id) throws Exception {
		return repository.findById(id).orElseThrow(Exception::new);
	}

	@Override
	public void saveTicket(TicketEntity ticket) {
		repository.save(ticket);
	}

	@Override
	public void updateTicket(TicketEntity request) {
		repository.save(request);
	}

	@Override
	public void deleteTicket(Integer id) {
		repository.deleteById(id);
	}

}
