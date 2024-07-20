package com.backend.TicketingApp.repository;

import com.backend.TicketingApp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
