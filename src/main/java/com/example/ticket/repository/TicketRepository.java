package com.example.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticket.entity.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

	
	public void deleteByShiftNumber(@Param("shiftNumber") Integer shiftNumber);

}
