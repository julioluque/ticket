package com.example.ticket.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket.dto.TicketResponseDTO;
import com.example.ticket.entity.TicketEntity;
import com.example.ticket.service.TicketService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "/tickets")
@Log4j2
public class TicketController {

	private TicketService ticketService;

	@Autowired
	@Qualifier("ticketService")
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping
	public ResponseEntity<List<TicketResponseDTO>> getAll(@RequestParam(required = false) LocalDate date) {
		List<TicketResponseDTO> response = null;
		try {
			response = ticketService.findAll();

			if (response.isEmpty()) {
				log.info("getAll: Not Found");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			log.info("getAll: Internal Server Error");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("getAll: Success");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TicketEntity> getSpecificTicket(@PathVariable Integer id) {
		TicketEntity response = null;
		try {
			response = ticketService.findById(id);

			if (response == null) {
				log.info("getSpecificTicket: Not Found");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.info("getSpecificTicket: Internal Server Error");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		log.info("getSpecificTicket: Success");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<TicketEntity> saveNewTicket(@RequestBody TicketEntity ticket) {
		try {
			ticketService.saveTicket(ticket);
			return new ResponseEntity<>(ticket, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(ticket, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<TicketEntity> updateTicket(@PathVariable Integer id, @RequestBody TicketEntity ticketEntity) {

		TicketEntity ticketDB = null;
		try {
			ticketDB = ticketService.findById(id);
			if (ticketDB == null) {
				log.info("updateTicket: Not Found");
				return new ResponseEntity<>(ticketDB, HttpStatus.NOT_FOUND);
			}
			ticketDB.setAttentionDate(ticketEntity.getAttentionDate());
			ticketDB.setStatus(true);
			ticketService.updateTicket(ticketDB);

		} catch (Exception e) {
			log.info("updateTicket: Internal Server Error");
			return new ResponseEntity<>(ticketEntity, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		log.info("updateTicket: Success");
		return new ResponseEntity<>(ticketDB, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<TicketEntity> suspendTicket(@PathVariable Integer id) {
		TicketEntity ticketDB = null;
		try {
			ticketDB = ticketService.findById(id);
			if (ticketDB == null) {
				log.info("suspendTicket: Not Found");
				return new ResponseEntity<>(ticketDB, HttpStatus.NOT_FOUND);
			}
			ticketDB.setStatus(false);
			ticketService.updateTicket(ticketDB);

		} catch (Exception e) {
			log.info("suspendTicket: Internal Server Error");
			return new ResponseEntity<>(ticketDB, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		log.info("suspendTicket: Success");
		return new ResponseEntity<>(ticketDB, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTicketById(@PathVariable Integer id) {
		try {
			ticketService.deleteTicketById(id);
		} catch (Exception e) {
			log.info("deleteTicketById: Internal Server Error");
			return new ResponseEntity<>("deleteTicketById: Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("deleteTicketById: Success");
		return new ResponseEntity<>("deleteTicketById: deleted", HttpStatus.OK);
	}

	@DeleteMapping("shiftNumber/{shiftNumber}")
	public ResponseEntity<String> deleteTicketByShiftNumber(@PathVariable Integer shiftNumber) {
		try {
			ticketService.deleteTicketByShiftNumber(shiftNumber);
		} catch (Exception e) {
			log.info("deleteTicketById: Internal Server Error");
			return new ResponseEntity<>("deleteTicketByShiftNumber: Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("deleteTicketByShiftNumber: Success");
		return new ResponseEntity<>("deleteTicketByShiftNumber: deleted", HttpStatus.OK);
	}
}
