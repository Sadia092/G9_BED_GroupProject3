package com.project.tta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tta.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>
{
	
}
